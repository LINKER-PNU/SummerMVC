package ac.linker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
// @RequestMapping(value = "/")
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        System.out.println("###############GotoIndex################");
        return "hello";
    }

    // @RequestMapping(value = "/login")
    // public String login(){
    //     return "hello";
    // }

    @RequestMapping(value="/login")
    public String login(@RequestParam("code") String code){
        System.out.println("#########code#########");
        System.out.println("code : " + code);
        return "hello";
    }
    
    
}
