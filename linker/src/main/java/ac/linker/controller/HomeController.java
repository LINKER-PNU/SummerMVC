package ac.linker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
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

    private ModelMapper modelMapper = new ModelMapper();
    private Gson gson = new Gson();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HomeController(HomeService homeService, ResponseService responseService) {
        this.homeService = homeService;
        this.responseService = responseService;
    }

    @RequestMapping(value = "/")
    public String index() {
        logger.info("###############GotoIndex################");

        return "hello";
    }

    // login and register
    @PostMapping(value = "/login", produces = "application/json; charset=utf8")
    public String userLogin(@RequestBody UserVo userVo) {

        UserDto userDto = modelMapper.map(userVo, UserDto.class);

        Optional<Character> optional = Optional.ofNullable(userVo.getSkinRole());

        logger.info("userLogin :: " + userVo.getDisplayName() + "(" + userVo.getUserId() + ") :: "
                + optional.orElse('N') + " :: " + (userVo.getNewPlayer() ? "newPlayer" : "oldPlayer"));

        if (userVo.getNewPlayer()) {
            try {
                // insert the informations, user registered
                homeService.insertUser(userDto);
            } catch (Exception e) {
                logger.error(e + " :: Errors on insert query  :: insertUser\n");
            }
        } else {
            try {
                // update token
                homeService.updateToken(userDto);
                logger.info("User " + userVo.getDisplayName() + " insert complete.\n");
            } catch (Exception e) {
                logger.error(e + " :: Errors on insert/update query  :: updateToken\n");
            }
        }
        return responseService.getResultResponse(true);
        // send the result by json
    }

    // get user informaiton by id
    @PostMapping(value = "/user", produces = "application/json; charset=utf8")
    public String getUserInfo(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);
        logger.info("getUserInfo :: " + userVo.getUserId());

        Map<String, Object> userInfo = new HashMap<String, Object>();

        final List<Map<String, Object>> userResult;
        try {
            userResult = homeService.getUser(userDto);
        } catch (Exception e) {
            logger.error(e + " :: Errors on select query :: getUser\n");
            return responseService.getResultResponse(false);
        }

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

        final String userInfoJson = gson.toJson(userInfo); // need rewrite
        logger.info("User " + userInfo.get("user_name") + " select complete.\n");

        return userInfoJson;
    }

    // update skin color and role
    @PostMapping(value = "/skin", produces = "application/json; charset=utf8")
    public String updateSkinColor(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);

        logger.info("updateSkinColor :: " + userVo.getUserId() + " :: " + userVo.getSkinColor());
        homeService.updateSkinColor(userDto);

        logger.info("User skin color update complete.\n");
        return responseService.getResultResponse(true);
    }
}
