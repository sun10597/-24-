package org.example.msp1.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.msp1.domain.Friend;
import org.example.msp1.domain.User;
import org.example.msp1.service.FriendService;
import org.example.msp1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("friends")
public class FriendController {
    private final UserService userService;
    private final FriendService friendService;

    @GetMapping
    public String friendList(Model model,
                             HttpSession session){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/users/login";
        }
        model.addAttribute("loginUser", loginUser);

        List<User> myF = friendService.getRealFriends(loginUser.getId());
        List<User> reF = friendService.getRecommendFriends(loginUser, myF);

        model.addAttribute("myF", myF);
        model.addAttribute("reF", reF);
        return "friend/main";
    }

    @PostMapping("addProc")
    public String addFriendProc(@RequestParam("userId") Long userId,
                                HttpSession session){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/users/login";
        }

        friendService.addFriend(new Friend(null, loginUser.getId(), userId));
        return "redirect:/friends";
    }
}
