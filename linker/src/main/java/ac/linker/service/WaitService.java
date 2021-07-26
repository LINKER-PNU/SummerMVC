package ac.linker.service;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ac.linker.controller.HomeController;

@Service
public class WaitService {

    // @Async
    public void waiting(HttpServletResponse response, JsonObject jsonObject) throws InterruptedException {
        System.out.println("###############Async################");
        while(!HomeController.flag){
            Thread.sleep(10000);
            System.out.println("Waiting...");
        }
        try{
            System.out.println(response);
            response.getWriter().print(jsonObject);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Signal received!");
    }
}

/*
HomeController.java
    @RequestMapping(value = "/signal")
    public String signal() {
        System.out.println("###############Signal!################");
        flag = true;
        return "hello";
    }

    try {
        waitService.waiting(response, jsonObject);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
*/
