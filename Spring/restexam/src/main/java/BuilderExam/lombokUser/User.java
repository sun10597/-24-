package BuilderExam.lombokUser;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
public class User {
    @Builder.Default
    private String name="guest";
    @Builder.Default
    private int age=0;
    private String email;
    private String address;
}
