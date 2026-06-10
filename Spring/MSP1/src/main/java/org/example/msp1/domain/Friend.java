package org.example.msp1.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table("friend")
public class Friend {
    @Id
    private Long id;
    private Long userId;
    private Long friendId;

}
