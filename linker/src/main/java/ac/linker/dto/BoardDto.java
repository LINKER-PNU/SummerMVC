package ac.linker.dto;

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
    private boolean boardVisible;

    public BoardDto() {
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
