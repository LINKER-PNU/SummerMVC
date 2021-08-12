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

    private int skinColor;
    private char skinRole;
}
