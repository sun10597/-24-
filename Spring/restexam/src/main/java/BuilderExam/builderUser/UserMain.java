package BuilderExam.builderUser;

public class UserMain {
    public static void main(String[] args) {
        User kim = new User.Builder()
                .name("kim")
                .age(20)
                .email("kim@gmail.com")
                .address("서울시")
                .build();

        System.out.println(kim);

        
        User lee = User.builder()
                .name("lee")
                .age(15)
                .email("lee@gmail.com")
                .address("서울시 영등포구")
                .build();
    }
}
