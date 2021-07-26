package ac.linker.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.linker.dto.UserDto;
import ac.linker.service.ConnectService;
import ac.linker.service.WaitService;

@Controller
public class HomeController {
    private ConnectService connectService;

    @Autowired
    HomeController(ConnectService connectService, WaitService waitService){
        this.connectService = connectService;
    }

    @RequestMapping(value = "/")
    public String index() {
        System.out.println("###############GotoIndex################");
        return "hello";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void method(@RequestBody Map<String,Object> param, HttpServletResponse response) {
        
        String authToken = param.get("authToken").toString();
        String displayName = param.get("displayName").toString();
        String userId = param.get("userId").toString();
        boolean newPlayer = Boolean.parseBoolean(param.get("newPlayer").toString());
        // make string or boolean from received information(post/json)

        System.out.println("authToken : " + authToken);
        System.out.println("displayName : " + displayName);
        System.out.println("userId : " + userId);
        System.out.println("newPlayer : " + newPlayer);
        
        if(newPlayer){
            connectService.insertUser(new UserDto(authToken, displayName, userId));
            // insert the informations
            
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("result", true);
            try {
                response.getWriter().print(jsonObject);
                // send the result by json
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            // update token
        }
    }
}
