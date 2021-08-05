package ac.linker.vo;

public class UserVO {
    private String authToken;
    private String displayName;
    private String userId;
    private boolean newPlayer;

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
    
    public boolean getNewPlayer(){
        return this.newPlayer;
    }
    public void setNewPlayer(Boolean newPlayer){
        this.newPlayer = newPlayer;
    }

}
