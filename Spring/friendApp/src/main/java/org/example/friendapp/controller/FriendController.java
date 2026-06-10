package org.example.friendapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendapp.Repository.FriendRepository;
import org.example.friendapp.domain.Friend;
import org.example.friendapp.serviece.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    //친구추가
    @GetMapping("/add")
    public String friendAdd(){
        return "friend/add";
    }
    @PostMapping("/addProc")
    public String friendAddProc(@ModelAttribute Friend friend){
        friendService.addFriend(friend);
        return "redirect:/friends";
    }

    //친구목록
    @GetMapping
    public String friendList(Model model,
                             @PageableDefault(size = 5, sort = "id",
                             direction = Sort.Direction.DESC) Pageable pageable){
//        Iterable<Friend> friends = friendService.getFriends();
        Page<Friend> friends = friendService.getFriends(pageable);
        model.addAttribute("friends", friends);
        return "friend/list";

    }

    //친구상세
    @GetMapping("/{id}")
    public String friendView(@PathVariable("id") Long id, Model model){
        Friend friend = friendService.getFriend(id);
        model.addAttribute("friend", friend);
        return "friend/view";
    }

    //친구수정
    @GetMapping("/{id}/edit")
    public String friendEdit(@PathVariable("id") Long id, Model model){
        Friend friend = friendService.getFriend(id);
        model.addAttribute("friend", friend);
        return "friend/edit";
    }
    @PostMapping("/{id}/editProc")
    public String friendEditProc(@PathVariable("id") int id,
                                 @ModelAttribute Friend friend){
        friendService.updateFriend(friend);
        return "redirect:/friends/" + id;
    }

    //친구삭제
    @PostMapping("/{id}/delete")
    public String friendDetele(@PathVariable("id") Long id){
        friendService.deleteFriend(id);
        return "redirect:/friends";
    }
}
