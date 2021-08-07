package ac.linker.vo;

public class BoardVo {
    private String boardWriter;
    private String boardRoom;

    private String boardTitle;
    private String boardContent;
    private String boardDeadline;

    private boolean boardNotice;
    private boolean boardAssignment;
    private boolean boardVisible;

	public String getBoardWriter() {
		return this.boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardRoom() {
		return this.boardRoom;
	}

	public void setBoardRoom(String boardRoom) {
		this.boardRoom = boardRoom;
	}

	public String getBoardTitle() {
		return this.boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return this.boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public boolean isBoardNotice() {
		return this.boardNotice;
	}

	public void setBoardNotice(boolean boardNotice) {
		this.boardNotice = boardNotice;
	}

    public boolean isBoardAssignment() {
		return this.boardAssignment;
	}

	public void setBoardAssignment(boolean boardAssignment) {
		this.boardAssignment = boardAssignment;
	}

	public boolean isBoardVisible() {
		return this.boardVisible;
	}

	public void setBoardVisible(boolean boardVisible) {
		this.boardVisible = boardVisible;
	}

    public String getBoardDeadline() {
		return this.boardDeadline;
	}

	public void setBoardDeadline(String boardDeadline) {
		this.boardDeadline = boardDeadline;
	}
}