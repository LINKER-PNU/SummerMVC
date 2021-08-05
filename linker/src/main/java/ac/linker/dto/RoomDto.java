package ac.linker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

// @Data
public class RoomDto {
    private int roomNo;
    private String roomName;
    private String roomCode = "temp_code";
    private int roomPresent = 0;
    private int roomMax = 0;
    private String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    
    private int roomAgoraUid;
    private String roomAgoraToken;

    public RoomDto() {
    }

    public RoomDto(final String roomName) {
        this.roomName = roomName;
    }

    public RoomDto(String roomName, String roomCode, int roomPresent, int roomMax) {
        this.roomName = roomName;
        this.roomCode = roomCode;
        this.roomPresent = roomPresent;
        this.roomMax = roomMax;
    }

    public int getNo() {
        return roomNo;
    }

    public void setCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public void setAgoraUid(int roomAgoraUid) {
        this.roomAgoraUid = roomAgoraUid;
    }

    public void setAgoraToken(String roomAgoraToken) {
        this.roomAgoraToken = roomAgoraToken;
    }
}
