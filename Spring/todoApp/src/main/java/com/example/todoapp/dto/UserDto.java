package com.example.todoapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
    @Getter
    @Setter
    @Schema(description = "회원가입 요처 DTO")
    public static class RegisterRequestDto {
        @Schema(description = "사용자 이메일", example = "user@user.com", requiredMode = Schema.RequiredMode.REQUIRED)
        private String email;
        private String name;
        private String password;
    }

    @Getter
    @Schema(description = "로그인 응답 DTO")
    public static class LoginResponseDto {
        private String accessToken;

        public LoginResponseDto(String accessToken){
            this.accessToken = accessToken;
        }
    }

    @Getter
    @Setter
    @Schema(description = "로그인 요청 DTO")
    public static class LoginRequestDto {
        @Schema(example = "user@user.com")
        private String email;
        @Schema(example = "1234")
        private String password;
    }
}
