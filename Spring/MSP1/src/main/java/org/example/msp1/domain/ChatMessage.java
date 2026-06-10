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
@Table("chat_message")
public class ChatMessage {
    @Id
    private Long id;
    private Long ChatRoomId;
    private Long senderId;
    private String content;
    private LocalDateTime sendAt;
}
