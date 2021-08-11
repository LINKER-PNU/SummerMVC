package ac.linker.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.RoomDto;
import ac.linker.media.RtcTokenBuilder;
import ac.linker.media.RtcTokenBuilder.Role;
import ac.linker.service.AgoraService;
import ac.linker.vo.AgoraVo;

@RestController
public class AgoraController {
    static String appId = "ee7508ef6b2042e7b6dd141a6a11895a";
    static String appCertificate = "c6903f1bcc1e4097abbb1352a8fed7d7";
    static int expirationTimeInSeconds = 100;
    RtcTokenBuilder token = new RtcTokenBuilder();

    private AgoraService agoraService;

    @Autowired
    AgoraController(AgoraService agoraService) {
        this.agoraService = agoraService;
    }

    @PostMapping(value = "/get_token", produces = "application/json; charset=utf8")
    public String getToken(@RequestBody AgoraVo agoraVo) {

        final String channelName = agoraVo.getRoomName();
        System.out.println("get_token :: " + channelName);
        RoomDto roomDto = new RoomDto(channelName);

        final List<Map<String, Object>> queryResult = agoraService.getAgoraToken(roomDto);
        Optional<Map<String, Object>> optional = Optional.ofNullable(queryResult.get(0));

        if (optional.isPresent()) {
            // token exist
            System.out.println("Token exist!");
            return queryResult.get(0).get("room_agora_token").toString();
        } else {
            // token not exist
            System.out.println("Token not exist! Generate token.");
            try {

                int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);

                final String roomAgoraToken = token.buildTokenWithUid(appId, appCertificate, channelName, 0,
                        Role.Role_Publisher, timestamp);
                roomDto.setAgoraToken(roomAgoraToken);
                agoraService.updateAgoraToken(roomDto);

                return roomAgoraToken;

            } catch (Exception e) {
                return "-1";
            }
        }
    }

    @PostMapping(value = "/check_class_exist", produces = "application/json; charset=utf8")
    public String checkClassExist(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();

        System.out.println("Check class exist :: " + channelName);

        final List<Map<String, Object>> uidQueryResult = agoraService.getAgoraUid(new RoomDto(channelName));
        Optional<Map<String, Object>> optional = Optional.ofNullable(uidQueryResult.get(0));

        final boolean existResult = optional.isPresent();

        if (existResult) {
            System.out.println("Class exist!");
        } else {
            System.out.println("Class not exist...");
        }

        return String.valueOf(existResult);
    }

    @PostMapping(value = "/insert_class_master", produces = "application/json; charset=utf8")
    public String insertClassMaster(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();
        final String uid = agoraVo.getClassMaster();

        System.out.println("Insert class master :: " + channelName + " :: " + uid);

        RoomDto roomDto = new RoomDto(channelName);
        roomDto.setAgoraUid(uid);

        try {
            agoraService.updateAgoraUid(roomDto);
            return "true";
        } catch (Exception e) {
            agoraService.resetAgora(roomDto);
            return "false";
        }
    }

    @PostMapping(value = "/delete_class_master", produces = "application/json; charset=utf8")
    public String deleteClassMaster(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();
        System.out.println("Delete class exist :: " + channelName);

        try {
            agoraService.resetAgora(new RoomDto(channelName));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

    @PostMapping(value = "/is_class_master", produces = "application/json; charset=utf8")
    public String isClassMaster(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();
        final String uid = agoraVo.getClassMaster();

        System.out.println("Is class master :: " + channelName + " :: " + uid);

        final List<Map<String, Object>> queryResult = agoraService.getAgoraUid(new RoomDto(channelName));

        final boolean equalsResult = uid.equals(queryResult.get(0).get("room_agora_uid").toString());

        if (equalsResult) {
            System.out.println(uid + " is class master of " + channelName + "!");
        } else {
            System.out.println(uid + " is not class master of " + channelName + "...");
        }

        return String.valueOf(equalsResult);
    }
}
