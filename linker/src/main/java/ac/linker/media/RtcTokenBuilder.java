package ac.linker.media;

public class RtcTokenBuilder {
    public enum Role{
        Role_Attendee(0),Role_Publisher(1),Role_Subscriber(2),Role_Admin(101);
    
        public int initValue;

        Role(int initValue){
            this.initValue = initValue;
        }
    }

    public String buildTokenWithUid(String appId, String appCertificate, String channelName, int uid, Role role, int privilegeTs){
        String account = uid == 0 ? "" : String.valueOf(uid);

        return;
    }

    public String buildTokenWithUserAccount(String appId, String appCertificate, String channelName, String account, Role role, int privilegeTs){

        AccessToken builder = new AccessToken(appId,appCertificate,channelName,account);
        builder.appPrivilege(AccessToken.Privileges.kJoinChannel)

}
