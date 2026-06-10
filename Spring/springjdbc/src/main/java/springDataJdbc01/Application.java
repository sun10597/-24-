package springDataJdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            System.out.println("=== Repository 패턴 예제 ===\n");

            // 1. CREATE - 저장
            System.out.println("1. 사용자 저장");
            User user1 = new User("이영희", "lee@example.com");
            User user2 = new User("박민수", "park@example.com");

            userRepository.save(user1);
            userRepository.save(user2);

            // 2. READ - 전체 조회
            System.out.println("\n2. 전체 사용자 조회");
            Iterable<User> allUsers = userRepository.findAll();
            allUsers.forEach(user ->
                    System.out.println(user.getId() + ": " +
                            user.getName() + " - " + user.getEmail())
            );

            // 3. READ - ID로 조회
            System.out.println("\n3. ID로 조회");
            Optional<User> foundUser = userRepository.findById(1L);
            foundUser.ifPresent(user ->
                    System.out.println("ID 1번 사용자: " + user.getName())
            );

            // 4. READ - 이름으로 조회 (커스텀 메소드)
            System.out.println("\n4. 이름으로 조회");
            Optional<User> userByName = userRepository.findByName("이영희");
            userByName.ifPresent(user ->
                    System.out.println("찾은 사용자: " + user.getName())
            );

            // 5. UPDATE - 수정
            System.out.println("\n5. 사용자 정보 수정");
            foundUser.ifPresent(user -> {
                user.setEmail("new.email@example.com");
                userRepository.save(user);  // save()는 UPDATE도 수행
                System.out.println("이메일 수정 완료");
            });

            // 6. DELETE - 삭제 (주석 처리)
            // userRepository.deleteById(2L);
        };
    }
}