package com.example.todoapp.dto;

import com.example.todoapp.entity.Todo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class TodoDto {

    @Getter
    @Setter
    @Schema(description = "할 일 생성 요청 객체")
    public static class CreateRequest {
        @Schema(description = "할 일 제목", example = "스프링 부트 복습하기")
        private String title;

        @Schema(description = "할 일 상세 내용", example = "3.5.x 버전 변경점 확인")
        private String content;
    }

    @Getter
    @Setter
    @Schema(description = "할 일 응답 객체")
    public static class Response {
        @Schema(description = "할 일 ID", example = "1")
        private Long id;
        @Schema(description = "할 일 제목", example = "스프링 부트 복습하기")
        private String title;
        @Schema(description = "할 일 상세 내용", example = "3.5.x 버전 변경점 확인")
        private String content;
        @Schema(description = "완료 여부", example = "false")
        private boolean completed;

        public static Response fromEntity(Todo todo) {
            Response response = new Response();
            response.setId(todo.getId());
            response.setTitle(todo.getTitle());
            response.setContent(todo.getContent());
            response.setCompleted(todo.isCompleted());
            return response;
        }
    }
}