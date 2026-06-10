package springDataJdbc02;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("books")
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private Boolean available;
    @CreatedDate
    private LocalDateTime createdAt;
}
