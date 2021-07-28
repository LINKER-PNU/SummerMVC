package ac.linker.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.linker.dto.JoinDto;
import ac.linker.dto.RoomDto;
import ac.linker.service.ConnectService;

@Controller
public class ConnectController {
    private ConnectService connectService;

    @Autowired
    ConnectController(ConnectService connectService) {
        this.connectService = connectService;
    }

    @RequestMapping(value = "/user")
    public String getUser() {
        System.out.println("################getAllUser##################");
        System.out.println(connectService.getAllUser());
        return "hello";
    }

    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathCreate(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();
        
        System.out.println("PathCreate : " + info + "\n");
        String roomName = param.get("GameId").toString();
        
        String userId = param.get("UserId").toString();
        
        // room insert
        connectService.insertRoom(new RoomDto(roomName,"temp_code",0,(int)((Map<String,Object>)param.get("CreateOptions")).get("MaxPlayers")));
        // user join
        connectService.insertJoin(new JoinDto(userId, roomName));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);
        
        response.getWriter().print(jsonObject);
    }
    
    @RequestMapping(value = "/close", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathClose(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathClose : " + info + "\n");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathEvent(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathEvent : " + info + "\n");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/game_properties", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathGameProperties(@RequestBody Map<String, Object> param, HttpServletResponse response)
            throws IOException {
        String info = param.toString();

        System.out.println("PathGameProperites : " + info + "\n");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathJoin(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathJoin : " + info + "\n");
        
        String roomName = param.get("GameId").toString();
        
        String userId = param.get("UserId").toString();
        
        // user join
        connectService.insertJoin(new JoinDto(userId, roomName));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/leave", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathLeave(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathLeave : " + info + "\n");
        
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/auth_room", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void authRoom(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String roomCode = param.get("joinCode").toString();

        System.out.println("roomCode : " + roomCode);

        // List<Map<String, Object>> roomName = connectService.getRoomByCode(new RoomDto("", roomCode, 0, 0));
        

        response.getWriter().print(connectService.getRoomByCode(new RoomDto("", roomCode, 0, 0)).get(0).get("room_name").toString());
    }

    @RequestMapping(value = "/room_code", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void responseRoomCode(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String roomName = param.get("roomName").toString();

        System.out.println("roomName : " + roomName);

        response.getWriter().print(connectService.getRoomByCode(new RoomDto(roomName, "", 0, 0)).get(0).get("room_code").toString());        
    }
}
