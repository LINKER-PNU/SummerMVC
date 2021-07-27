package ac.linker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ac.linker.service.ConnectService;

@Controller
public class ConnectController {
    private ConnectService connectService;

    @Autowired
    ConnectController(ConnectService connectService) {
        this.connectService = connectService;
    }

    @RequestMapping(value = "/user")
    public String getUser() {
        System.out.println("################getAllUser##################");
        System.out.println(connectService.getAllUser());
        return "hello";
    }
}
