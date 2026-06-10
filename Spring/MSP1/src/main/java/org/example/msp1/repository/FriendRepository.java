package org.example.msp1.repository;

import org.example.msp1.domain.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByUserId(Long userId);
}
