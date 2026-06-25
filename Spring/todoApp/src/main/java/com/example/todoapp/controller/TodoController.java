package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.service.TodoService;
import com.example.todoapp.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Todo API", description = "할 일 관리 API")
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    private final JwtUtil jwtUtil;

    @PostMapping
    @Operation(summary = "할 일 추가", description = "새로운 할 일을 추가합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TodoDto.Response> createTodo(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader,
            @RequestBody TodoDto.CreateRequest request){
        // 1. Authorization 헤더에서 Bearer 토큰 추출
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build(); // 토큰이 없으면 인증 실패
        }
        String token = authorizationHeader.substring(7);

        // 2. JwtUtil을 사용해 토큰 검증 후 사용자 고유 ID(userId) 꺼내기
        Long userId = jwtUtil.validateToken(token);
        if (userId == null) {
            return ResponseEntity.status(401).build(); // 유효하지 않은 토큰이면 인증 실패
        }

        // 3. 서비스에 userId와 request를 함께 넘겨주기 (오류 해결!)
        return ResponseEntity.ok(todoService.createTodo(userId, request));
    }

    @GetMapping
    @Operation(summary = "할 일 목록 조회", description = "저장된 모든 할 일 목록을 가져옵니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<TodoDto.Response>> getAllTodos(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        Long userId = getUserIdFromToken(authorizationHeader);
        return ResponseEntity.ok(todoService.getAllTodos(userId));
    }

    @PatchMapping("/{id}/complete")
    @Operation(summary = "할 일 완료 상태 변경", description = "할 일의 완료 여부(true/false)를 토글합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<TodoDto.Response> toggleComplete(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader,
            @PathVariable Long id) {
        Long userId = getUserIdFromToken(authorizationHeader);
        return ResponseEntity.ok(todoService.toggleComplete(userId, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "할 일 삭제", description = "특정 할 일을 삭제합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> deleteTodo(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader,
            @PathVariable Long id) {
        Long userId = getUserIdFromToken(authorizationHeader);
        todoService.deleteTodo(userId, id);
        return ResponseEntity.noContent().build();
    }

    private Long getUserIdFromToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("인증 토큰이 누락되었습니다.");
        }
        String token = authorizationHeader.substring(7);
        Long userId = jwtUtil.validateToken(token);
        if (userId == null) {
            throw new IllegalArgumentException("유효하지 않거나 만료된 토큰입니다.");
        }
        return userId;
    }
}
