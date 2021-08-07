package ac.linker.vo;

public class UserVo {
    private String authToken;
    private String displayName;
    private String userId;
    private boolean newPlayer;

    private int skinColor;
    private char skinRole;

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

    public int getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

    public char getSkinRole() {
        return this.skinRole;
    }

    public void setSkinRole(char skinRole) {
        this.skinRole = skinRole;
    }
}
