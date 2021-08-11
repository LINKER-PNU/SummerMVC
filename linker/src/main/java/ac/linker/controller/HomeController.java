package ac.linker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.UserDto;
import ac.linker.service.HomeService;
import ac.linker.service.ResponseService;
import ac.linker.vo.UserVo;

@RestController
public class HomeController {
    private HomeService homeService;
    private ResponseService responseService;
    private Gson gson = new Gson();
    // private final Logger logger = LoggerFactory

    @Autowired
    HomeController(HomeService homeService, ResponseService responseService) {
        this.homeService = homeService;
        this.responseService = responseService;
    }

    @RequestMapping(value = "/")
    public String index() {
        System.out.println("###############GotoIndex################");

        return "hello";
    }

    // login and register
    @PostMapping(value = "/login", produces = "application/json; charset=utf8")
    public String userLogin(@RequestBody UserVo userVo) {

        final String authToken = userVo.getAuthToken();
        final String displayName = userVo.getDisplayName();
        final String userId = userVo.getUserId();
        final boolean newPlayer = userVo.getNewPlayer();
        // make string or boolean from received information(post/json)

        System.out.println("userLogin :: " + displayName + " :: " + userId + " :: "
                + (newPlayer ? "newPlayer" : "oldPlayer") + "\n");

        final UserDto userDto = new UserDto(authToken, displayName, userId);

        if (newPlayer) {
            homeService.insertUser(userDto);
            // insert the informations, user registered
        } else {
            homeService.updateToken(userDto);
            // update token
        }

        return responseService.getResultResponse(true);
        // send the result by json
    }

    // get user informaiton by id
    @PostMapping(value = "/user", produces = "application/json; charset=utf8")
    public String getUserInfo(@RequestBody Map<String, Object> param) {
        final String userId = param.get("userId").toString();
        final UserDto userDto = new UserDto(userId);
        final List<Map<String, Object>> userResult = homeService.getUser(userDto);

        System.out.println("getUserInfo :: " + userId);

        Map<String, Object> userInfo = new HashMap<String, Object>();

        if (!userResult.isEmpty()) {
            userInfo.put("result_user", "success");
            userInfo.put("user_name", userResult.get(0).get("user_name"));
            userInfo.put("user_skin_color", userResult.get(0).get("user_skin_color"));
            userInfo.put("user_skin_role", userResult.get(0).get("user_skin_role"));
        } else {
            userInfo.put("result_user", "empty set");
        }

        final List<Map<String, Object>> userRoomResult = homeService.getRoom(userDto);
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

    // update skin color and role
    @PostMapping(value = "/skin", produces = "application/json; charset=utf8")
    public String updateSkin(@RequestBody UserVo userVo) {
        final UserDto userDto = new UserDto(userVo.getUserId(), userVo.getSkinColor(), userVo.getSkinRole());

        homeService.updateSkin(userDto);

        System.out.println("updateSkin :: " + userVo.getUserId());

        return responseService.getResultResponse(true);
    }
}
