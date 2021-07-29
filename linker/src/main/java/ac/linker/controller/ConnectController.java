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

    private JsonObject getSucceed(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        return jsonObject;
    }

    @RequestMapping(value = "/user")
    public String getUser() {
        System.out.println("################getAllUser##################");
        System.out.println(connectService.getAllUser());
        return "hello";
    }

    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathCreate(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathCreate : " + requestObject + "\n");
        String roomName = param.get("GameId").toString();
        String userId = param.get("UserId").toString();
        
        final RoomDto userRoom = new RoomDto(
            roomName,
            "temp_code",
            0,
            requestObject.getAsJsonObject("CreateOptions").get("MaxPlayers").getAsInt()
        );
        // room insert
        connectService.insertRoom(userRoom);

        userRoom.setCode(CodeGenerator.getCode(userRoom.getNo()));

        connectService.updateRoomCode(userRoom);
        // update room code

        // user join
        
        try {
            connectService.insertJoin(new JoinDto(userId, roomName));
            System.out.println(userId + "joined" + roomName + "\n");
        } catch (DuplicateKeyException e) {
            System.out.println("Member "+userId+" exists on room "+roomName+"! Duplicated pair is prevented.\n");
        } 
        
        response.getWriter().print(getSucceed());
    }
    
    @RequestMapping(value = "/close", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathClose(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathClose : " + requestObject + "\n");

        // delete room

        response.getWriter().print(getSucceed());
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathEvent(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathEvent : " + requestObject + "\n");

        response.getWriter().print(getSucceed());
    }

    @RequestMapping(value = "/game_properties", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathGameProperties(@RequestBody Map<String, Object> param, HttpServletResponse response)
            throws IOException {
        JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathGameProperites : " + requestObject + "\n");

        response.getWriter().print(getSucceed());
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathJoin(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathJoin : " + requestObject + "\n");
        
        String roomName = param.get("GameId").toString();
        
        String userId = param.get("UserId").toString();
        
        // user join
        connectService.insertJoin(new JoinDto(userId, roomName));

        response.getWriter().print(getSucceed());
    }

    @RequestMapping(value = "/leave", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathLeave(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        JsonObject requestObject = gson.toJsonTree(param).getAsJsonObject();

        System.out.println("PathLeave : " + requestObject + "\n");
        
        response.getWriter().print(getSucceed());
    }

    @RequestMapping(value = "/auth_room", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void authRoom(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String roomCode = param.get("joinCode").toString();
        String roomName;

        System.out.println("Received roomCode : " + roomCode);

        List<Map<String, Object>> queryResult = connectService.getRoomByCode(new RoomDto("", roomCode, 0, 0));

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
        String roomName = param.get("roomName").toString();
        String roomCode;
        
        System.out.println("Received roomName : " + roomName);
        
        roomCode = connectService.getCodeByName(new RoomDto(roomName, "", 0, 0)).get(0).get("room_code").toString();
        System.out.println("Response roomCode : " + roomCode + "\n");
        
        response.getWriter().print(roomCode);        
    }
}
