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
        
        String id = param.get("id").toString();
        String pw = param.get("pw").toString();
        
        System.out.println("id" + id);
        System.out.println("pw" + pw);
        return "hello";
    }
}
