package ac.linker.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;

@Controller
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

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void method(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {

        String authToken = param.get("authToken").toString();
        String displayName = param.get("displayName").toString();
        String userId = param.get("userId").toString();
        boolean newPlayer = Boolean.parseBoolean(param.get("newPlayer").toString());
        // make string or boolean from received information(post/json)

        System.out.println("authToken : " + authToken);
        System.out.println("displayName : " + displayName);
        System.out.println("userId : " + userId);
        System.out.println("newPlayer : " + newPlayer);

        UserDto user = new UserDto(authToken, displayName, userId);

        if (newPlayer) {
            connectService.insertUser(user);
            // insert the informations

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("result", true);

            response.getWriter().print(jsonObject);
            // send the result by json

        } else {
            connectService.updateToken(user);
            // update token and response user info

            List<Map<String, Object>> userName = connectService.getUserName(user);
            List<Map<String, Object>> userSkin = connectService.getSkin(user);
            List<Map<String, Object>> userRoom = connectService.getRoom(user);
            // select username, skin, roomlists

            // System.out.println(userName);
            // System.out.println(userSkin);
            // System.out.println(userRoom);

            Map<String, Object> userInfo = new HashMap<String, Object>();
            userInfo.put("user_name", userName.get(0).get("user_name"));
            userInfo.put("skin_color", userSkin.get(0).get("skin_color"));
            userInfo.put("skin_role", userSkin.get(0).get("skin_role"));
            userInfo.put("rooms", userRoom);

            Gson gson = new Gson();
            String userInfoJson = gson.toJson(userInfo);
            System.out.println(userInfoJson);
            response.getWriter().print(userInfoJson);
        }
    }

    @RequestMapping(value = "/photon", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public String webHook(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println(info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        return jsonObject.toString();
    }
}
