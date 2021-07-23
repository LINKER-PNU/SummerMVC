package ac.linker.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;

@Controller
public class HomeController {
    private ConnectService connectService;

    @Autowired
    HomeController(ConnectService connectService){
        this.connectService = connectService;
    }

    @RequestMapping(value = "/")
    public String index() {
        System.out.println("###############GotoIndex################");
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public @ResponseBody String method(@RequestBody Map<String,Object> param) {
        
        String authToken = param.get("authToken").toString();
        String displayName = param.get("displayName").toString();
        String userId = param.get("userId").toString();
        boolean newPlayer = Boolean.parseBoolean(param.get("newPlayer").toString());
        
        System.out.println("authToken : " + authToken);
        System.out.println("displayName : " + displayName);
        System.out.println("userId : " + userId);
        System.out.println("newPlayer : " + newPlayer);
        
        if(newPlayer){
            connectService.insertUser(new UserDto(authToken, displayName, userId));
        }
        else{
            // update token
        }
        return "hello";
    }
}
