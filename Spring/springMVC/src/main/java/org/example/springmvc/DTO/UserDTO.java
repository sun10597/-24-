package org.example.springmvc.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class UserDTO {
    @Data
    public static class Join{
        @NotEmpty(message = "이메일을 입력하세요")
        private String email;

        @NotEmpty(message = "비밀번호를 입력하세요")
        @Size(min = 8, message = "비민번호는 8자이상 입력하세요")
        @Pattern(regexp = ".*\\d.*", message = "숫자가 1개이상 포함되어야 합니다")
        private String password;

        @NotEmpty(message = "이름을 입력하세요")
        private String name;
    }
}
