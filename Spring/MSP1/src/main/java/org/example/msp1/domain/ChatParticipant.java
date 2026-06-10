package org.example.msp1.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("chat_participant")
public class ChatParticipant {
    @Id
    private Long id;
    private Long chatRoomId;
    private Long userId;
}
