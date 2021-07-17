package ac.linker.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @RequestMapping(value = "/")
    public String index() {
        System.out.println("###############GotoIndex################");
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public @ResponseBody String method(@RequestBody Map<String,Object> param) {
        
        String authToken = param.get("authToken").toString();
        String displayName = param.get("displayName").toString();
        String newPlayer = param.get("newPlayer").toString();
        String userId = param.get("userId").toString();

        
        System.out.println("authToken : " + authToken);
        System.out.println("displayName : " + displayName);
        System.out.println("newPlayer : " + newPlayer);
        System.out.println("userId : " + userId);
        
        return "hello";
    }
}
