package ac.linker.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ac.linker.media.RtcTokenBuilder;
import ac.linker.media.RtcTokenBuilder.Role;

@RestController
public class AgoraController {
    static String appId = "970CA35de60c44645bbae8a215061b32";
    static String appCertificate = "5CFd2fd1755d40ecb72977518be15d3b";
    static int expirationTimeInSeconds = 3600;
    RtcTokenBuilder token = new RtcTokenBuilder();
    
    @PostMapping(value="token_uid", produces = "application/json; charset=utf8")
    public String getTokenByUid(@RequestBody Map<String,Object> param){
        
        final int uid = (int)param.get("uid");
        final String channelName = param.get("channelName").toString();
        
        int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        
        final String tokenString = token.buildTokenWithUid(appId, appCertificate, channelName, uid, Role.Role_Publisher, timestamp);

        return tokenString;
    }

    @PostMapping(value="token_account", produces = "application/json; charset=utf8")
    public String getTokenByAccount(@RequestBody Map<String,Object> param){
        
        final String userAccount = param.get("userAccount").toString();
        final String channelName = param.get("channelName").toString();
        
        int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        
        final String tokenString = token.buildTokenWithUserAccount(appId, appCertificate, channelName, userAccount, Role.Role_Publisher, timestamp);

        return tokenString;
    }
}
