package lion.jdbc.scheduler.dto;

import java.time.LocalDateTime;

public class ScheduleDTO {
    private int scheduleId;
    private String title;
    private String content;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String status;
    private int categoryId;
    private LocalDateTime createdAt;

    public ScheduleDTO(){}

    @Override
    public String toString() {
        return  " 제목 : '" + title + '\'' +
                "\n 내용 : '" + content + '\'' +
                "\n 시작시간 : " + startAt +
                "\n 종료시간 : " + endAt +
                "\n 상태 : '" + status + '\'' +
                "\n 카테고리 ID " + categoryId +
                "\n 들록시간 : " + createdAt +
                '}';
    }

    public ScheduleDTO(int scheduleId, String title, String content, LocalDateTime startAt,
                       LocalDateTime endAt, String status, int categoryId, LocalDateTime createdAt){
       this.scheduleId = scheduleId;
       this.title = title;
       this.content = content;
       this.startAt = startAt;
       this.endAt = endAt;
       this.status = status;
       this.categoryId = categoryId;
       this.createdAt = createdAt;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
