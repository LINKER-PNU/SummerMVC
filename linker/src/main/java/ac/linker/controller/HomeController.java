package ac.linker.controller;

import java.text.Format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private boolean resultStatus;
    private String resultMessage;

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

        logger.info("userLogin :: {}({}) :: {} :: {}", userVo.getDisplayName(), userVo.getUserId(),
                (userVo.getSkinRole() == '\0' ? 'N' : userVo.getSkinRole()),
                (userVo.getNewPlayer() ? "newPlayer" : "oldPlayer"));

        try {
            if (userVo.getNewPlayer()) {
                // User sign up. Insert user.
                homeService.insertUser(userDto);

                resultMessage = String.format("User %s insert complete.\n", userVo.getDisplayName());
                logger.info(resultMessage);
            }

            else if (homeService.getUser(userDto).isEmpty()) {
                // User doesn't exist in DB, but exists in gamesparks. Insert user.

                userDto.setSkinRole('S'); // Skin role is set to student forcibily.
                homeService.insertUser(userDto);

                resultMessage = String.format("%s doesn't exist in DB... Insert complete.\n", userVo.getDisplayName());
                logger.warn(resultMessage);

            }

            else {
                // User exists in DB, user sign in, update token
                homeService.updateToken(userDto);

                resultMessage = String.format("User %s login complete.\n", userVo.getDisplayName());
                logger.info(resultMessage);
            }

            resultStatus = true;
        } catch (Exception e) {
            resultMessage = String.format("%s :: Errors on insert query :: insertUser\n", e.toString());
            resultStatus = false;
            logger.error(resultMessage);
        }

        return responseService.getResultResponse(resultStatus, resultMessage);
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
            userInfo.put("user_skin_cloth", userResult.get(0).get("user_skin_cloth"));
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

    @PostMapping(value = "/cloth", produces = "application/json; charset=utf8")
    public String updateSkinCloth(@RequestBody UserVo userVo) {
        final UserDto userDto = modelMapper.map(userVo, UserDto.class);

        logger.info("updateSkinColor :: {} :: {}", userVo.getUserId(), userVo.getSkinCloth());
        homeService.updateSkinCloth(userDto);

        logger.info("User skin cloth update complete.\n");
        return responseService.getResultResponse(true);
    }
}
