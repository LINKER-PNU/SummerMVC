package ac.linker.vo;

public class UserVO {
    private String authToken;
    private String displayName;
    private String userId;
    private String newPlayer;

    public String getAuthToken(){
        return this.authToken;
    }
    public void setAuthToken(String authToken){
        this.authToken = authToken;
    }
    
    public String getDisplayName(){
        return this.displayName;
    }
    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    
    public String getUserId(){
        return this.userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getNewPlayer(){
        return this.newPlayer;
    }
    public void setNewPlayer(String newPlayer){
        this.newPlayer = newPlayer;
    }

}
