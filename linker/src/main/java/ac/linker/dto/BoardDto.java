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

    private String boardWriteDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private String boardEditDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private String boardDeadline;

    private boolean boardNotice;
    private boolean boardAssignment;
    private boolean boardVisible = true;

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public void setBoardWriterId(String boardWriterId) {
        this.boardWriterId = boardWriterId;
    }

    public void setBoardRoom(String boardRoom) {
        this.boardRoom = boardRoom;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public void setBoardDeadline(String boardDeadline) {
        this.boardDeadline = boardDeadline;
    }

    public void setBoardNotice(boolean boardNotice) {
        this.boardNotice = boardNotice;
    }

    public void setBoardAssignment(boolean boardAssignment) {
        this.boardAssignment = boardAssignment;
    }
}
