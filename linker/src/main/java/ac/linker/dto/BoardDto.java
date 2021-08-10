package ac.linker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {
    private int boardId;

    private String boardWriter;
    private String boardRoom;
    private String boardTitle;
    private String boardContent;

    private String boardWriteDt;
    private String boardEditDt;
    private String boardDeadline;

    private boolean boardNotice;
    private boolean boardAssignment;
    private boolean boardVisible = true;

    public BoardDto(){}
    
	public BoardDto(String boardWriter, String boardRoom, String boardTitle, String boardContent, String boardDeadline,
	boolean boardNotice, boolean boardAssignment) {
		this.boardWriter = boardWriter;
		this.boardRoom = boardRoom;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDeadline = boardDeadline;
		this.boardNotice = boardNotice;
		this.boardAssignment = boardAssignment;

		this.boardWriteDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		this.boardEditDt = this.boardWriteDt;
	}

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
