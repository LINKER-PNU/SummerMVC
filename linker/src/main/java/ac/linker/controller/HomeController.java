package ac.linker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;
import ac.linker.vo.UserVO;

@RestController
public class HomeController {
    private ConnectService connectService;

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
    public String method(@RequestBody UserVO userVO) {

        final String authToken = userVO.getAuthToken();
        final String displayName = userVO.getDisplayName();
        final String userId = userVO.getUserId();
        final boolean newPlayer = Boolean.parseBoolean(userVO.getNewPlayer());
        // make string or boolean from received information(post/json)

        System.out.println("authToken : " + authToken);
        System.out.println("displayName : " + displayName);
        System.out.println("userId : " + userId);
        System.out.println("newPlayer : " + newPlayer + "\n");

        final UserDto userDto = new UserDto(authToken, displayName, userId);

        if (newPlayer) {

            connectService.insertUser(userDto);
            // insert the informations

            final JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("result", true);

            return jsonObject.toString();
            // send the result by json

        } else {
            Map<String, Object> userInfo = new HashMap<String, Object>();

            connectService.updateToken(userDto);
            // update token and response userDto info

            final List<Map<String, Object>> userResult = connectService.getUser(userDto);
            if (!userResult.isEmpty()){
                userInfo.put("user_name", userResult.get(0).get("user_name"));
                userInfo.put("user_skin_color", userResult.get(0).get("user_skin_color"));
                userInfo.put("user_skin_role", userResult.get(0).get("user_skin_role"));
            }
            else{
                userInfo.put("user_name", "");
            }
            
            final List<Map<String, Object>> userRoomResult = connectService.getRoom(userDto);
            if (!userRoomResult.isEmpty()){
                userInfo.put("user_room", userRoomResult);
            }
            else{
                userInfo.put("user_room", "");
            }
            // select username, skin, roomlists

            Gson gson = new Gson();
            String userInfoJson = gson.toJson(userInfo);
            System.out.println(userInfoJson);

            return userInfoJson;
        }
    }
}
