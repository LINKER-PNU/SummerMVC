// package ac.linker.controller;

// import java.util.HashMap;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import ac.linker.service.KakaoAPI;


// @Controller
// // @RequestMapping(value = "/")
// public class HomeController {
    
//     @Autowired
//     private KakaoAPI kakao;

//     @RequestMapping(value = "/")
//     public String index() {
//         System.out.println("###############GotoIndex################");
//         return "hello";
//     }

//     @RequestMapping(value="/login")
//     public String login(@RequestParam("code") String code){
        
//         String accessToken = kakao.getAccessToken(code);
//         System.out.println("controller::access_token : " + accessToken);

//         HashMap<String,Object> userInfo = kakao.getUserInfo(accessToken);
//         System.out.println("controller::userInfo : " + userInfo);

//         return "hello";
//     }
    
    
// }