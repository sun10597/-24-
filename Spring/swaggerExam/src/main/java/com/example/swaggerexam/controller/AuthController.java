package com.example.swaggerexam.controller;

import com.example.swaggerexam.dto.LoginRequestDto;
import com.example.swaggerexam.dto.LoginResponseDto;
import com.example.swaggerexam.dto.RegisterRequestDto;
import com.example.swaggerexam.service.UserService;
import com.example.swaggerexam.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Operation(
            summary = "웰컴",
            description = "월컴임"
    )
    @GetMapping("/welcome")
    @SecurityRequirement(name = "bearerAuth")
    public String welcome(@RequestHeader("Authorization") String authorizationHeader) {
        if(authorizationHeader != null){
            String token = authorizationHeader.substring(7);
            if(token != null){
                return "welcome";
            }
        }
        return "인증 후 볼 수 있습니다.";
    }


    @Operation(
            summary = "테스트",
            description = "동작이 잘 되는지 테스트"
    )

    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @Operation(
            summary = "회원가입",
            description = "사용자가 이메일과 비밀번호를 입력하면 회원가입을 합니다."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "회원가입 성공",
                        content = @Content(mediaType = "text/plain",
                            schema = @Schema(type = "String", example = "회원가입 성공")
                        )
                    ),
                    @ApiResponse(responseCode = "400", description = "회원가입 실패",
                            content = @Content(mediaType = "text/plain",
                                    schema = @Schema(type = "String", example = "회원가입 실패")
                            )
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto requestDto){


        String message = userService.register(requestDto.getEmail(), requestDto.getPassword());
        if("존재하는 아이디 입니다.".equals(message))
            return ResponseEntity.status(400).body(message);
        return ResponseEntity.ok(message);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        //수정필요  (시스템이 가진 정보와 연결해서 로그인:: 현재는 1L아이디로 로그인)
        Long userId=1L;
        String token = jwtUtil.generateToken(userId);

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @Operation(summary = "로그아웃")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.substring(7);
        jwtUtil.invalidateToken(token);
        return ResponseEntity.ok("로그아웃 성공");
    }
}
