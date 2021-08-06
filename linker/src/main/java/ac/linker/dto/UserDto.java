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

    public UserDto(final String displayName){
        this.displayName = displayName;
    }

    public UserDto(final String authToken,final String displayName,final String userId){
        this.authToken = authToken;
        this.displayName = displayName;
        this.userId = userId;
        System.out.println(joinDate);
    }   
}
