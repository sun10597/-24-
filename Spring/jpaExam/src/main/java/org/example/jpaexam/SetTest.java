package org.example.jpaexam;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        User user1 = new User("Alice", "alice@gmail.com");
        User user2 = new User("lin", "lin@gmail.com");

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);


    }
}
