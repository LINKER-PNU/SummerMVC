package ac.linker.vo;

public class BoardVo {
	private int boardId;

	private String boardWriter;
	private String boardWriterId;
	private String boardRoom;

	private String boardTitle;
	private String boardContent;

	private String boardWriteDt;
	private String boardEditDt;
	private String boardDeadline;

	private boolean boardNotice;
	private boolean boardAssignment;
	private boolean boardVisible;

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardWriter() {
		return this.boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardWriterId() {
		return boardWriterId;
	}

	public void setBoardWriterId(String boardWriterId) {
		this.boardWriterId = boardWriterId;
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
