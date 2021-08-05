package ac.linker;

import ac.linker.media.RtcTokenBuilder;
import ac.linker.media.RtcTokenBuilder.Role;

public class RtcTokenBuilderSample {
    static String appId = "970CA35de60c44645bbae8a215061b32";
    static String appCertificate = "5CFd2fd1755d40ecb72977518be15d3b";
    static String channelName = "linker_test";
    static String userAccount = "2082341273";
    static int uid = 0;

    static int expirationTimeInSeconds = 3600;

    public static void RtcTokenBuilderSampleMethod() throws Exception {
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        String result = token.buildTokenWithUserAccount(appId, appCertificate, channelName, userAccount,
                Role.Role_Publisher, timestamp);
        System.out.println(result);

        result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, Role.Role_Publisher, timestamp);
        System.out.println(result);
    }
}