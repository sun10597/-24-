package com.example.todoapp.controller;

import com.example.todoapp.dto.UserDto;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.service.UserService;
import com.example.todoapp.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Auth API", description = "인증 및 회원 관리 API")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository; // 👈 로그인 검증용 추가
    private final JwtUtil jwtUtil;

    @Operation(summary = "회원가입", description = "사용자가 이메일과 비밀번호를 입력하면 회원가입을 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공", content = @Content(schema = @Schema(example = "회원가입성공!!"))),
            @ApiResponse(responseCode = "400", description = "회원가입 실패", content = @Content(schema = @Schema(example = "존재하는 아이디 입니다.")))
    })
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto.RegisterRequestDto requestDto){
        String message = userService.register(requestDto.getEmail(), requestDto.getName(), requestDto.getPassword());
        if("존재하는 아이디 입니다.".equals(message))
            return ResponseEntity.status(400).body(message);
        return ResponseEntity.ok(message);
    }

    @Operation(summary = "로그인", description = "이메일과 비밀번호로 로그인하여 토큰을 발급받습니다.")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto.LoginRequestDto loginRequestDto){
        // 👈 하드코딩 제거하고 DB와 검증 연동
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다."));

        if(!user.getPassword().equals(loginRequestDto.getPassword())) {
            return ResponseEntity.status(401).body("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.generateToken(user.getId());
        return ResponseEntity.ok(new UserDto.LoginResponseDto(token));
    }

    @Operation(summary = "로그아웃")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader){
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(400).body("잘못된 토큰 정보입니다.");
        }

        String token = authorizationHeader.substring(7);

        Long userId = jwtUtil.validateToken(token);
        if (userId == null) {
            return ResponseEntity.status(401).body("유효하지 않거나 이미 만료된 토큰입니다.");
        }
        jwtUtil.invalidateToken(token);
        return ResponseEntity.ok("로그아웃 성공");
    }
}