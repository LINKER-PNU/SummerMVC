package ac.linker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

    private int resultStatus;

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

                logger.info(String.format("User %s insert complete.\n", userVo.getDisplayName()));
            }

            else if (homeService.getUser(userDto).isEmpty()) {
                // User doesn't exist in DB, but exists in gamesparks. Insert user.

                userDto.setSkinRole('S'); // Skin role is set to student forcibily.
                homeService.insertUser(userDto);

                logger.warn(String.format("%s doesn't exist in DB... Insert complete.\n", userVo.getDisplayName()));

            }

            else {
                // User exists in DB, user sign in, update token
                homeService.updateToken(userDto);
                logger.info(String.format("User %s login complete.\n", userVo.getDisplayName()));
            }

            resultStatus = 200;
        } catch (Exception e) {
            resultStatus = 500;
            logger.error(String.format("%s :: Errors on insert query :: insertUser\n", e.toString()));
        }

        return responseService.getResultResponse(resultStatus);
        // send the result by json
    }

    // get user informaiton by id
    @PostMapping(value = "/user", produces = "application/json; charset=utf8")
    public String getUserInfo(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);
        logger.info("getUserInfo :: {}", userVo.getUserId());

        Optional<Map<String, Object>> userOptional;
        List<Map<String, Object>> userRoomResult;

        try {
            // select user name, skin
            userOptional = Optional.ofNullable(homeService.getUser(userDto));
            if (userOptional.isPresent()) {
                resultStatus = 200;
            } else {
                // if there is not user client requests
                resultStatus = 400;
            }
        } catch (Exception e) {
            logger.error(String.format("%s :: Errors on select query :: getUser\n", e.toString()));
            resultStatus = 500;
            return responseService.getResultResponse(resultStatus);
        }

        try {
            // select room list
            userRoomResult = homeService.getRoom(userDto);
        } catch (Exception e) {
            logger.error(String.format("%s :: Errors on select query :: getRoom\n", e.toString()));
            resultStatus = 500;
            return responseService.getResultResponse(resultStatus);
        }

        // convert map result to json object
        JsonObject userJsonObject = gson.toJsonTree(userOptional.orElse(new HashMap<>())).getAsJsonObject();
        userJsonObject.add("user_room", gson.toJsonTree(userRoomResult).getAsJsonArray());
        userJsonObject.addProperty("result", resultStatus);

        logger.info("User {} select complete.\n", userJsonObject.get("user_name"));
        return userJsonObject.toString();
    }

    // update skin color and role
    @PostMapping(value = "/skin", produces = "application/json; charset=utf8")
    public String updateSkinColor(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);

        logger.info("updateSkinColor :: {} :: {}", userVo.getUserId(), userVo.getSkinColor());

        try {
            homeService.updateSkinColor(userDto);
            resultStatus = 200;
            logger.info("User skin color update complete.\n");
        } catch (Exception e) {
            resultStatus = 500;
            logger.error("{} :: Errors on select query :: updateSkinColor\n", e.toString());
        }

        return responseService.getResultResponse(resultStatus);
    }

    @PostMapping(value = "/cloth", produces = "application/json; charset=utf8")
    public String updateSkinCloth(@RequestBody UserVo userVo) {
        UserDto userDto = modelMapper.map(userVo, UserDto.class);

        logger.info("updateSkinColor :: {} :: {}", userVo.getUserId(), userVo.getSkinCloth());

        try {
            homeService.updateSkinCloth(userDto);
            resultStatus = 200;
            logger.info("User skin cloth update complete.\n");
        } catch (Exception e) {
            resultStatus = 500;
            logger.error("{} :: Errors on select query :: updateSkinCloth\n", e.toString());
        }

        return responseService.getResultResponse(resultStatus);
    }
}
