package BuilderExam.builderUser;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private final String name;
    private final int age;
    private final String email;
    private final String address;

    private User(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String name="guest";
        private int age=20;
        private String email="guest@gmail.com";
        private String address="서울시 강남구";

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
