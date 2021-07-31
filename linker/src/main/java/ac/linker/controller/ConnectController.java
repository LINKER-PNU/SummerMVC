package ac.linker.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.service.CodeGenerator;
import ac.linker.service.ConnectService;

@Controller
public class ConnectController {
    private Gson gson = new Gson();
    private ConnectService connectService;

    @Autowired
    ConnectController(ConnectService connectService) {
        this.connectService = connectService;
    }

    private JsonObject getResponseJson(final int status){
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", status);

        return jsonObject;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathCreate(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathCreate : " + requestObject + "\n");
        final String roomName = param.get("GameId").toString();
        final String userId = param.get("UserId").toString();
        final String userName = param.get("Nickname").toString();
        final String reqType = param.get("Type").toString();
        
        RoomDto roomDto = new RoomDto(roomName);

        // requestObject.getAsJsonObject("CreateOptions").get("MaxPlayers").getAsInt()
        System.out.println("reqType : " + reqType);
        
        if(reqType.equals("Create") ){
            // room insert
            try {
                connectService.insertRoom(roomDto);
                response.getWriter().print(getResponseJson(1));
            } catch (DuplicateKeyException e) {
                System.out.println("Warning! RoomName " + roomName + " duplicated!");
            }

            while(true){ // prevent duplicated code.
                try {
                    roomDto.setCode(CodeGenerator.getCode(roomDto.getNo()));
                    connectService.updateRoomCode(roomDto);
                    break;
                } catch (DuplicateKeyException e) {
                    System.out.println("Warning! Invite code " + roomDto.getNo() + " duplicated!");
                }
            }
            // create and update room code

            connectService.insertJoin(new JoinDto(userId, roomName));
            System.out.println(userId + " :: " + userName + " joined " + roomName + "\n");
            connectService.updateRoomNewJoin(roomDto);
            // join room
        }

        if(reqType.equals("Load")){
            System.out.println(userId + " :: " + userName + " recreated " + roomName + "\n");
            connectService.updateRoomJoin(roomDto);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);
        System.out.println(jsonObject);
        response.getWriter().print(jsonObject);
    }
    
    @RequestMapping(value = "/join", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathJoin(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathJoin : " + requestObject + "\n");
        
        final String roomName = param.get("GameId").toString();
        final String userId = param.get("UserId").toString();
        final String userName = param.get("Nickname").toString();
        
        // user join
        try {
            connectService.insertJoin(new JoinDto(userId, roomName));
            connectService.updateRoomNewJoin(new RoomDto(roomName));
            System.out.println(userId + " :: " + userName + "joined" + roomName + "\n");
        } catch (DuplicateKeyException e) {
            connectService.updateRoomJoin(new RoomDto(roomName));
            System.out.println("Member "+ userId + " :: " + userName +" is already in room "+roomName+"! Duplicated pair is prevented.\n");
        }

        response.getWriter().print(getResponseJson(0));
    }

    @RequestMapping(value = "/leave", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathLeave(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();
        
        final String roomName = param.get("GameId").toString();

        System.out.println("PathLeave : " + requestObject + "\n");

        connectService.updateRoomLeave(new RoomDto(roomName, "", 0, 0));
        
        response.getWriter().print(getResponseJson(0));
    }

    @RequestMapping(value = "/close", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathClose(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathClose : " + requestObject + "\n");

        // delete room

        response.getWriter().print(getResponseJson(0));
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathEvent(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathEvent : " + requestObject + "\n");

        response.getWriter().print(getResponseJson(0));
    }

    @RequestMapping(value = "/game_properties", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathGameProperties(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathGameProperites : " + requestObject + "\n");

        response.getWriter().print(getResponseJson(0));
    }

    @RequestMapping(value = "/auth_room", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void authRoom(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final String roomCode = param.get("joinCode").toString();
        final String roomName;

        System.out.println("Received roomCode : " + roomCode);

        RoomDto roomDto = new RoomDto();
        roomDto.setCode(roomCode);
        final List<Map<String, Object>> queryResult = connectService.getRoomByCode(roomDto);

        if (!queryResult.isEmpty()){
            roomName = queryResult.get(0).get("room_name").toString();
        }
        else{
            roomName = "";
        }
        System.out.println("Response roomName : " + roomName + "\n");

        response.getWriter().print(roomName);
    }

    @RequestMapping(value = "/room_code", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void responseRoomCode(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final String roomName = param.get("roomName").toString();
        final String roomCode;
        
        System.out.println("Received roomName : " + roomName);
        
        roomCode = connectService.getCodeByName(new RoomDto(roomName)).get(0).get("room_code").toString();
        System.out.println("Response roomCode : " + roomCode + "\n");
        
        response.getWriter().print(roomCode);
    }

    @RequestMapping(value = "/room_exist", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void checkRoomExist(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        final String roomName = param.get("roomName").toString();
        
        response.getWriter().print(
            !connectService.findRoom(new RoomDto(roomName)).isEmpty()
        );

    }
}
