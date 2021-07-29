package ac.linker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

// @Data
public class RoomDto {
    private String roomName;
    private String roomCode;
    private int roomPresent;
    private int roomMax;
    private String createDate;
    private int roomNo;

    public RoomDto(String roomName,String roomCode,int roomPresent, int roomMax){
        this.roomName = roomName;
        this.roomCode = roomCode;
        this.roomPresent = roomPresent;
        this.roomMax = roomMax;

        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String createDate = dateFormat.format(new Date());
        // System.out.println(createDate);
        this.createDate = createDate;
    }

    public int getNo(){
        return roomNo;
    }

    public void setCode(String roomCode){
        this.roomCode = roomCode;
    }
}
