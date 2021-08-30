/**
* Original Code
* https://github.com/AgoraIO/Tools/blob/master/DynamicKey/AgoraDynamicKey/java/src/main/java/io/agora/media/RtcTokenBuilder.java
*/

package ac.linker.media;

public class RtcTokenBuilder {
    public enum Role {
        Role_Attendee(0), Role_Publisher(1), Role_Subscriber(2), Role_Admin(101);

        public int initValue;

        Role(int initValue) {
            this.initValue = initValue;
        }
    }

    public String buildTokenWithUid(String appId, String appCertificate, String channelName, int uid, Role role,
            int privilegeTs) {
        String account = uid == 0 ? "" : String.valueOf(uid);

        return buildTokenWithUserAccount(appId, appCertificate, channelName, account, role, privilegeTs);
    }

    public String buildTokenWithUserAccount(String appId, String appCertificate, String channelName, String account,
            Role role, int privilegeTs) {

        AccessToken builder = new AccessToken(appId, appCertificate, channelName, account);
        builder.addPrivilege(AccessToken.Privileges.kJoinChannel, privilegeTs);

        if (role == Role.Role_Publisher || role == Role.Role_Subscriber || role == Role.Role_Admin) {
            builder.addPrivilege(AccessToken.Privileges.kPublishAudioStream, privilegeTs);
            builder.addPrivilege(AccessToken.Privileges.kPublishVideoStream, privilegeTs);
            builder.addPrivilege(AccessToken.Privileges.kPublishDataStream, privilegeTs);
        }

        try {
            return builder.build();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
