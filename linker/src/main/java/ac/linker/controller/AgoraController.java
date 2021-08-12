package ac.linker.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AgoraService agoraService;

    @Autowired
    AgoraController(AgoraService agoraService) {
        this.agoraService = agoraService;
    }

    @PostMapping(value = "/get_token", produces = "application/json; charset=utf8")
    public String getToken(@RequestBody AgoraVo agoraVo) {

        final String channelName = agoraVo.getRoomName();
        logger.info("getToken :: " + channelName);
        final RoomDto roomDto = new RoomDto(channelName);

        final List<Map<String, Object>> queryResult = agoraService.getAgoraToken(roomDto);
        Optional<Map<String, Object>> optional = Optional.ofNullable(queryResult.get(0));

        if (optional.isPresent()) {
            // token exist
            logger.info("Token exist!\n");
            return queryResult.get(0).get("room_agora_token").toString();
        } else {
            // token not exist
            logger.info("Token not exist! Generate token.\n");
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

        logger.info("checkClassExist :: " + channelName);

        final List<Map<String, Object>> uidQueryResult = agoraService.getAgoraUid(new RoomDto(channelName));
        Optional<Map<String, Object>> optional = Optional.ofNullable(uidQueryResult.get(0));

        final boolean existResult = optional.isPresent();

        if (existResult) {
            logger.info("Class exist!\n");
        } else {
            logger.warn("checkClassExist :: Class not exist...\n");
        }

        return String.valueOf(existResult);
    }

    @PostMapping(value = "/insert_class_master", produces = "application/json; charset=utf8")
    public String insertClassMaster(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();
        final String uid = agoraVo.getClassMaster();

        logger.info("insertClassMaster :: " + channelName + " :: " + uid);

        RoomDto roomDto = new RoomDto(channelName);
        roomDto.setAgoraUid(uid);

        try {
            agoraService.updateAgoraUid(roomDto);
            logger.info("Agora class master is updated to " + uid + ".\n");
            return "true";
        } catch (Exception e) {
            agoraService.resetAgora(roomDto);
            logger.error("insertClassMaster :: Agora class master insertion is failed! Reset class master.\n");
            return "false";
        }
    }

    @PostMapping(value = "/delete_class_master", produces = "application/json; charset=utf8")
    public String deleteClassMaster(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();
        logger.info("deleteClassMaster :: " + channelName);

        try {
            agoraService.resetAgora(new RoomDto(channelName));
            logger.info("Agora class master is reset at channel " + channelName + ".\n");
            return "true";
        } catch (Exception e) {
            logger.error("deleteClassMaster :: Agora class master resetting is failed!\n");
            return "false";
        }
    }

    @PostMapping(value = "/is_class_master", produces = "application/json; charset=utf8")
    public String isClassMaster(@RequestBody AgoraVo agoraVo) {
        final String channelName = agoraVo.getRoomName();
        final String uid = agoraVo.getClassMaster();

        logger.info("isClassMaster :: " + channelName + " :: " + uid);

        final List<Map<String, Object>> queryResult = agoraService.getAgoraUid(new RoomDto(channelName));

        final boolean equalsResult = uid.equals(queryResult.get(0).get("room_agora_uid").toString());

        if (equalsResult) {
            logger.info(uid + " is class master of " + channelName + "!\n");
        } else {
            logger.warn("isClassMaster :: " + uid + " is not class master of " + channelName + "...\n");
        }

        return String.valueOf(equalsResult);
    }
}
