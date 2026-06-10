package org.example.friendapp.serviece;

import lombok.RequiredArgsConstructor;
import org.example.friendapp.Repository.FriendRepository;
import org.example.friendapp.domain.Friend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    //친구목록
    @Transactional(readOnly = true)
    public Iterable<Friend> getFriends(){
        return friendRepository.findAll();
    }

    //친구추가
    @Transactional
    public Friend addFriend(Friend friend){
        return friendRepository.save(friend);
    }

    @Transactional(readOnly = true)
    public Friend getFriend(Long id){
        return friendRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Friend updateFriend(Friend friend){
        return friendRepository.save(friend);
    }

    @Transactional
    public void deleteFriend(Long id){
        friendRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<Friend> getFriends(Pageable pageable) {
        return friendRepository.findAll(pageable);
    }
}
