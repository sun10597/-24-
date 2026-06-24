package com.example.swaggerexam.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String accessToken;

    public LoginResponseDto(String accessToken){
        this.accessToken = accessToken;
    }
}
