package org.example.msp1.service;

import lombok.RequiredArgsConstructor;
import org.example.msp1.domain.Friend;
import org.example.msp1.domain.User;
import org.example.msp1.repository.FriendRepository;
import org.example.msp1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    @Transactional
    public Friend addFriend(Friend friend){
        return friendRepository.save(friend);
    }

    @Transactional(readOnly = true)
    public List<Friend> getFriendsByMe(Long userId){
        return friendRepository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public Friend getFriend(Long id){
        return friendRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void delFriend(Long id){
        friendRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getRealFriends(Long myId){
        List<Friend> friends = friendRepository.findByUserId(myId);
        List<User> friendsInfo = new ArrayList<>();
       for(Friend f : friends){
           userRepository.findById(f.getFriendId()).ifPresent(friendsInfo::add);
       }
         return friendsInfo;
    }

    @Transactional(readOnly = true)
    public List<User> getRecommendFriends(User me,
                                          List<User> myRealFriends) {
        Iterable<User> allUsers = userRepository.findAll();
        List<User> recommendFriendsInfo = new ArrayList<>();
        for (User u : allUsers) {
            if (!u.getId().equals(me.getId())) {
                boolean isFriend = myRealFriends.stream().anyMatch(f -> f.getId().equals(u.getId()));
                if (!isFriend) {
                    recommendFriendsInfo.add(u);
                }
            }
        }
        return recommendFriendsInfo;
    }
}
