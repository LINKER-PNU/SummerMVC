package ac.linker.dto;

public class BoardDto {
    private String boardWriter;
    private String boardRoom;

    private String boardTitle;
    private String boardContent;
    private String boardWriteDate;
    private String boardEditDate;

    private boolean boardNotice;
    private boolean boardVisible;

    public BoardDto(String boardWriter, String boardRoom, String boardTitle, String boardContent, String boardWriteDate,
            String boardEditDate, boolean boardNotice, boolean boardVisible) {
        this.boardWriter = boardWriter;
        this.boardRoom = boardRoom;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriteDate = boardWriteDate;
        this.boardEditDate = boardEditDate;
        this.boardNotice = boardNotice;
        this.boardVisible = boardVisible;
    }
}
