package ac.linker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.Optional;

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

    @PostMapping(value = "/test", produces = "application/json; charset=utf8")
    public String testRequest(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);
        System.out.println(userVo.getSkinRole() == '\0');

        return "aresult";
    }

    // login and register
    @PostMapping(value = "/login", produces = "application/json; charset=utf8")
    public String userLogin(@RequestBody UserVo userVo) {

        UserDto userDto = modelMapper.map(userVo, UserDto.class);

        // Optional<Character> optional = Optional.ofNullable(userVo.getSkinRole());

        logger.info("userLogin :: {}({}) :: {} :: {}", userVo.getDisplayName(), userVo.getUserId(),
                (userVo.getSkinRole() == '\0' ? 'N' : userVo.getSkinColor()),
                (userVo.getNewPlayer() ? "newPlayer" : "oldPlayer"));

        if (userVo.getNewPlayer()) {
            try {
                // insert the informations, user registered
                homeService.insertUser(userDto);
                logger.info("User {} insert complete.\n", userVo.getDisplayName());
            } catch (Exception e) {
                logger.error("{} :: Errors on insert query :: insertUser\n", e.toString());
            }
        } else {
            try {
                // update token
                homeService.updateToken(userDto);
                logger.info("User {} login complete.\n", userVo.getDisplayName());
            } catch (Exception e) {
                logger.error("{} :: Errors on insert/update query :: updateToken\n", e.toString());
            }
        }
        return responseService.getResultResponse(true);
        // send the result by json
    }

    // get user informaiton by id
    @PostMapping(value = "/user", produces = "application/json; charset=utf8")
    public String getUserInfo(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);
        logger.info("getUserInfo :: {}", userVo.getUserId());

        Map<String, Object> userInfo = new HashMap<String, Object>();

        final List<Map<String, Object>> userResult;
        try {
            userResult = homeService.getUser(userDto);
        } catch (Exception e) {
            logger.error("{} :: Errors on select query :: getUser\n", e.toString());
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
        logger.info("User {} select complete.\n", userInfo.get("user_name"));

        return userInfoJson;
    }

    // update skin color and role
    @PostMapping(value = "/skin", produces = "application/json; charset=utf8")
    public String updateSkinColor(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);

        logger.info("updateSkinColor :: {} :: {}", userVo.getUserId(), userVo.getSkinColor());
        homeService.updateSkinColor(userDto);

        logger.info("User skin color update complete.\n");
        return responseService.getResultResponse(true);
    }
}
