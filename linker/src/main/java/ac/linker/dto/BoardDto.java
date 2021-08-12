package ac.linker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {
    private int boardId;

    private String boardWriter;
    private String boardWriterId;
    private String boardRoom;
    private String boardTitle;
    private String boardContent;

    private String boardWriteDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
    private String boardEditDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
    private String boardDeadline;

    private boolean boardNotice;
    private boolean boardAssignment;
    private boolean boardVisible = true;

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardRoom() {
        return boardRoom;
    }

    public void setBoardRoom(String boardRoom) {
        this.boardRoom = boardRoom;
    }

}
