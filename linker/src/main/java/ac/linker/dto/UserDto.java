package ac.linker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

// @Data
public class UserDto {
    private String authToken;
    private String displayName;
    private String userId;
    private String joinDate;

    public UserDto(String authToken,String displayName,String userId, String newPlayer){
        this.authToken = authToken;
        this.displayName = displayName;
        this.userId = userId;
    }


    public UserDto(String authToken,String displayName,String userId){
        this.authToken = authToken;
        this.displayName = displayName;
        this.userId = userId;

        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String joinDate = dateFormat.format(new Date());
        System.out.println(joinDate);
        this.joinDate = joinDate;
    }

    public String getAuthToken(){
        return this.authToken;
    }
}
