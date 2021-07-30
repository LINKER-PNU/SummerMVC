package ac.linker.dto;

// @Data
public class JoinDto {
    private String userId;
    private String roomName;

    public JoinDto(String userId,String roomName){
        this.userId = userId;
        this.roomName = roomName;
    }
}
