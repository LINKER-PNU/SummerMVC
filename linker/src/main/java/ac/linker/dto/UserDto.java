package ac.linker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

// @Data
public class UserDto {
    private String authToken;
    private String displayName;
    private String userId;

    private String joinDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private String newPlayer;

    private String skinColor;
    private char skinRole;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public void setSkinRole(char skinRole) {
        this.skinRole = skinRole;
    }
}
