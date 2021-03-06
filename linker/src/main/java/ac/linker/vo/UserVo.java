package ac.linker.vo;

public class UserVo {
    private String authToken;
    private String displayName;
    private String userId;
    private boolean newPlayer;

    private String skinColor;
    private char skinRole;
    private String skinCloth;

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean getNewPlayer() {
        return this.newPlayer;
    }

    public void setNewPlayer(Boolean newPlayer) {
        this.newPlayer = newPlayer;
    }

    public String getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public char getSkinRole() {
        return this.skinRole;
    }

    public void setSkinRole(char skinRole) {
        this.skinRole = skinRole;
    }

    public String getSkinCloth() {
        return skinCloth;
    }

    public void setSkinCloth(String skinCloth) {
        this.skinCloth = skinCloth;
    }
}
