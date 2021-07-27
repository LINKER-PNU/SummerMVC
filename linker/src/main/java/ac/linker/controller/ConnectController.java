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

    @RequestMapping(value = "/close", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathClose(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathClose : " + info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathCreate(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathCreate : " + info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathEvent(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathEvent : " + info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/game_properties", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathGameProperties(@RequestBody Map<String, Object> param, HttpServletResponse response)
            throws IOException {
        String info = param.toString();

        System.out.println("PathGameProperites : " + info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathJoin(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathJoin : " + info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = "/leave", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public void pathLeave(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        String info = param.toString();

        System.out.println("PathLeave : " + info);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("State", "");
        jsonObject.addProperty("ResultCode", 0);

        response.getWriter().print(jsonObject);
    }
}
