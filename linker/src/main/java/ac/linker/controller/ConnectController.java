package ac.linker.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.service.CodeGenerator;
import ac.linker.service.ConnectService;
import ac.linker.service.ResponseService;

@RestController
public class ConnectController {
    private Gson gson = new Gson();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ConnectService connectService;
    private ResponseService responseService;

    @Autowired
    ConnectController(ConnectService connectService, ResponseService responseService) {
        this.connectService = connectService;
        this.responseService = responseService;
    }

    private int joinRoom(final String userId, final String roomName, final String userName) {
        final JoinDto joinDto = new JoinDto(userId, roomName);

        try {
            connectService.insertJoin(joinDto);
            connectService.updateRoomNewJoin(joinDto);
            connectService.updateJoiningRecentDt(joinDto);
            logger.info("User {} joined in room {}.\n", userName, roomName);
            return 0;
        } catch (DuplicateKeyException e) {
            connectService.updateRoomJoin(joinDto);
            connectService.updateJoiningRecentDt(joinDto);
            logger.info("User {} is already in room {}! Duplicated pair is prevented.\n", userName, roomName);
            return 1;
        } catch (DataIntegrityViolationException s) {
            logger.error("User {} is not in table user! Joining room is failed.\n", userName);
            return 3;
        }
    }

    @PostMapping(value = "/create", produces = "application/json; charset=utf8")
    public String pathCreate(@RequestBody Map<String, Object> param) {
        final String roomName = param.get("GameId").toString();
        final String userId = param.get("UserId").toString();
        final String userName = param.get("Nickname").toString();
        final String reqType = param.get("Type").toString();

        logger.info("pathCreate :: {} :: {} :: {}({})", reqType, roomName, userName, userId);

        RoomDto roomDto = new RoomDto(roomName);

        if (reqType.equals("Create")) {
            // room insert

            try { // prevent duplicated room name
                connectService.insertRoom(roomDto);
            } catch (DuplicateKeyException e) {
                logger.warn("pathCreate :: Room name {} is duplicated!\n", roomName);
                return responseService.getPhotonResponse(1);
            } catch (DataIntegrityViolationException m) {
                logger.warn("pathCreate :: Room name {} is over the max length(20)!\n", roomName);
                return responseService.getPhotonResponse(2);
            }

            while (true) { // create and update room code
                try {
                    String roomCode = CodeGenerator.getCode(roomDto.getNo());
                    roomDto.setCode(roomCode);

                    connectService.updateRoomCode(roomDto);
                    logger.info("Room code {} is set on room {}.", roomCode, roomName);

                    break;
                } catch (DuplicateKeyException e) { // prevent duplicated code.
                    logger.warn("pathCreate :: Generated invite code is duplicated! Regenerating code...");
                }
            }

            logger.info("User {} try to create and join in room {}.\n", userName, roomName);
            return responseService.getPhotonResponse(joinRoom(userId, roomName, userName));
            // join room
        }

        if (reqType.equals("Load")) {
            // if room is recreated
            logger.info("User {} try to recreate and join in room {}.\n", userName, roomName);
            return responseService.getPhotonResponse(joinRoom(userId, roomName, userName));
        }

        // Type is not available.
        return "-1";
    }

    @PostMapping(value = "/join", produces = "application/json; charset=utf8")
    public String pathJoin(@RequestBody Map<String, Object> param) {
        final String roomName = param.get("GameId").toString();
        final String userId = param.get("UserId").toString();
        final String userName = param.get("Nickname").toString();

        logger.info("pathJoin :: {} :: {}({})", roomName, userName, userId);

        // user join
        logger.info("User {} try to join in room {}.\n", userName, roomName);
        return responseService.getPhotonResponse(joinRoom(userId, roomName, userName));
    }

    @PostMapping(value = "/leave", produces = "application/json; charset=utf8")
    public String pathLeave(@RequestBody Map<String, Object> param) {
        final String roomName = param.get("GameId").toString();
        final String userId = param.get("UserId").toString();
        final String userName = param.get("Nickname").toString();

        logger.info("pathLeave :: {} :: {}({})", roomName, userName, userId);

        final RoomDto roomDto = new RoomDto(roomName);

        connectService.updateRoomLeave(roomDto);

        logger.info("User {} leaved {}.\n", roomName, userName);
        return responseService.getPhotonResponse(0);
    }

    @PostMapping(value = "/close", produces = "application/json; charset=utf8")
    public String pathClose(@RequestBody Map<String, Object> param) {
        final String roomName = param.get("GameId").toString();
        logger.info("pathClose :: {}", roomName);

        // delete room

        return responseService.getPhotonResponse(0);
    }

    @PostMapping(value = "/event", produces = "application/json; charset=utf8")
    public String pathEvent(@RequestBody Map<String, Object> param) {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathEvent : " + requestObject + "\n");

        return responseService.getPhotonResponse(0);
    }

    @PostMapping(value = "/game_properties", produces = "application/json; charset=utf8")
    public String pathGameProperties(@RequestBody Map<String, Object> param) {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathGameProperites : " + requestObject + "\n");

        return responseService.getPhotonResponse(0);
    }

    @PostMapping(value = "/auth_room", produces = "application/json; charset=utf8")
    public String authRoom(@RequestBody Map<String, Object> param) {
        final Optional<String> optional = Optional.ofNullable(param.get("joinCode").toString());
        final String roomCode = optional.orElse("");
        final String roomName;

        logger.info("authRoom :: Received roomCode {}", roomCode);

        RoomDto roomDto = new RoomDto();
        roomDto.setCode(roomCode);
        final List<Map<String, Object>> queryResult = connectService.getRoomByCode(roomDto);

        if (!queryResult.isEmpty()) {
            roomName = queryResult.get(0).get("room_name").toString();
        } else {
            logger.warn("authRoom :: There is no room has code {}", roomCode);
            roomName = "";
        }

        logger.info("Response roomName : {}\n", roomName);
        return roomName;
    }

    @PostMapping(value = "/room_code", produces = "application/json; charset=utf8")
    public String getRoomCode(@RequestBody Map<String, Object> param) {
        final Optional<String> optional = Optional.ofNullable(param.get("roomName").toString());
        final String roomName = optional.orElse("");
        final String roomCode;

        logger.info("getRoomCode :: Received roomName : {}", roomName);

        roomCode = connectService.getCodeByName(new RoomDto(roomName)).get(0).get("room_code").toString();

        logger.info("Response roomCode : {}\n", roomCode);
        return roomCode;
    }

    @PostMapping(value = "/room_exist", produces = "application/json; charset=utf8")
    public String checkRoomExist(@RequestBody Map<String, Object> param) {
        final Optional<String> optional = Optional.ofNullable(param.get("roomName").toString());
        final String roomName = optional.orElse("");
        final List<Map<String, Object>> queryResult = connectService.findRoom(new RoomDto(roomName));

        logger.info("checkRoomExist :: {}", roomName);

        final boolean roomExist = !queryResult.isEmpty();

        if (roomExist) {
            logger.info("Room name is duplicated! Creation is prevented...\n");
        } else {
            logger.info("Room name is available!\n");
        }

        return Boolean.toString(roomExist);
    }
}
