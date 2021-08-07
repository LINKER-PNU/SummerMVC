package ac.linker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;
import ac.linker.vo.UserVo;

@RestController
public class HomeController {
    private ConnectService connectService;
    private Gson gson = new Gson();
    // private final Logger logger = LoggerFactory


    @Autowired
    HomeController(ConnectService connectService) {
        this.connectService = connectService;
    }

    @RequestMapping(value = "/")
    public String index() {
        System.out.println("###############GotoIndex################");
        
        return "hello";
    }

    @PostMapping(value = "/login", produces = "application/json; charset=utf8")
    public String userLogin(@RequestBody UserVo userVO) {

        final String authToken = userVO.getAuthToken();
        final String displayName = userVO.getDisplayName();
        final String userId = userVO.getUserId();
        final boolean newPlayer = userVO.getNewPlayer();
        // make string or boolean from received information(post/json)
        
        System.out.println("userLogin :: " + 
            displayName + " :: " + 
            userId + " :: " + 
            (newPlayer ? "newPlayer" : "oldPlayer") + "\n");

        final UserDto userDto = new UserDto(authToken, displayName, userId);

        if (newPlayer) {
            connectService.insertUser(userDto);
            // insert the informations, user registered
        } else {
            connectService.updateToken(userDto);
            // update token
        }

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result_login", "success");

        return jsonObject.toString();
        // send the result by json
    }

    @PostMapping(value = "/user", produces = "application/json; charset=utf8")
    public String getUserInfo(@RequestBody Map<String, Object> param) {
        final String userName = param.get("user_id").toString();
        final UserDto userDto = new UserDto(userName);
        final List<Map<String, Object>> userResult = connectService.getUserByName(userDto);

        System.out.println("getUserInfo :: " + userName);

        Map<String, Object> userInfo = new HashMap<String, Object>();

        if (!userResult.isEmpty()) {
            userInfo.put("result_user", "success");
            userInfo.put("user_id", userResult.get(0).get("user_id"));
            userInfo.put("user_skin_color", userResult.get(0).get("user_skin_color"));
            userInfo.put("user_skin_role", userResult.get(0).get("user_skin_role"));
        } else {
            userInfo.put("result_user", "empty set");
        }

        final List<Map<String, Object>> userRoomResult = connectService.getRoomByName(userDto);
        if (!userRoomResult.isEmpty()) {
            userInfo.put("result_room", "success");
            userInfo.put("user_room", userRoomResult);
        } else {
            userInfo.put("result_room", "empty set");
        }
        // select username, skin, roomlists

        final String userInfoJson = gson.toJson(userInfo);
        System.out.println(userInfoJson + "\n");

        return userInfoJson;
    }

    @PostMapping(value = "/skin", produces = "application/json; charset=utf8")
    public String updateSkin(@RequestBody UserVo userVO) {
        final UserDto userDto = new UserDto(userVO.getDisplayName(), userVO.getSkinColor(), userVO.getSkinRole());

        connectService.updateSkin(userDto);

        System.out.println("updateSkin :: " + userVO.getDisplayName());

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result_skin", "success");

        return jsonObject.toString();
    }
}


