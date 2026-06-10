package org.example.jpaexam;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, email);
//    }
}

