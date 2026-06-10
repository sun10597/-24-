package org.example.friendapp;

import org.example.friendapp.Repository.FriendRepository;
import org.example.friendapp.domain.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class FriendRepositoyTest {
    @Autowired
    private FriendRepository friendRepository;

    @Test
    void save(){
        Friend newFriend = friendRepository.save(new Friend("soo", "soo@soo.com"));
        assertThat(newFriend.getId()).isNotNull();
    }
}
