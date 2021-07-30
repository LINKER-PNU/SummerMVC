package ac.linker.controller;

import java.util.Map;

import com.google.gson.JsonObject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.dto.UserDto;

@RestController
public class RestTestController {
    
    @PostMapping(value = "/rest_test", produces = "application/json; charset=utf8")
    public JsonObject testMethod(UserDto param){

        System.out.println(param);
        // final String authToken = param.get("authToken").toString();
        // final String displayName = param.get("displayName").toString();
        // final String userId = param.get("userId").toString();
        // final boolean newPlayer = Boolean.parseBoolean(param.get("newPlayer").toString());

        System.out.println("authToken : " + param.getAuthToken());
        // System.out.println("displayName : " + displayName);
        // System.out.println("userId : " + userId);
        // System.out.println("newPlayer : " + newPlayer);

        // final UserDto userDto = new UserDto(authToken, displayName, userId);

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", true);

        return jsonObject;
    }
    
}
