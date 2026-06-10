package lion.jdbc.member;
import java.time.LocalDateTime;

public class MemberDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime created;
    private LocalDateTime updated;

    public MemberDTO(){}

    public MemberDTO(int id, String name, String email, String password, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.updated = updated;
    }
    @Override
    public String toString() {
        return "MemberDTO [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ']';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
