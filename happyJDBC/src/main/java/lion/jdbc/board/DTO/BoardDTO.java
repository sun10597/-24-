package lion.jdbc.board.DTO;

import java.time.LocalDateTime;

public class BoardDTO {
    private int boardId;
    private String title;
    private String content;
    private String userId;
    private String authorName;
    private LocalDateTime regdate;
    private int viewCnt;

    public BoardDTO(){}

    public BoardDTO(int boardId, String title, String content, String userId, String author_name, LocalDateTime regdate, int viewCnt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.authorName = author_name;
        this.regdate = regdate;
        this.viewCnt = viewCnt;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    @Override
    public String toString() {
        return "BoardDTO [" +
                "번호=" + boardId +
                ", 제목='" + title + '\'' +
                ", 작성자='" + authorName + '\'' +
                ", 작성일=" + regdate +
                ", 조회수=" + viewCnt +
                ']';
    }
}
