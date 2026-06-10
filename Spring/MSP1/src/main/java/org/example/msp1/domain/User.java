package org.example.msp1.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("users")
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private String name;
    private Role role;
    private UserStatus status;
    private LocalDateTime createdAt;

}
