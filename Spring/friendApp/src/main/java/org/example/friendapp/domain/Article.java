package org.example.friendapp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("articles")
public class Article {
    @Id
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Article(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = LocalDateTime.now();
    }
}