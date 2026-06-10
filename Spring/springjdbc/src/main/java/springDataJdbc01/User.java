package springDataJdbc01;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    @CreatedDate
    private LocalDateTime createdAt;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
