package org.example.msp1.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("chat_room")
public class ChatRoom {
    @Id
    private Long id;
    private String title;
    private LocalDateTime createdAt;
}
