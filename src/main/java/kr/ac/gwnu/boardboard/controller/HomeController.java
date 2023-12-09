package kr.ac.gwnu.boardboard.controller;

import kr.ac.gwnu.boardboard.dto.PostDTO;
import kr.ac.gwnu.boardboard.dto.UserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "join";
    }

    @GetMapping("/allPosts")
    public String showAllPosts() {
        return "all-posts";
    }

    @GetMapping("/freeBoard")
    public String showFreeBoard() {
        return "free-board";
    }

    @GetMapping("/noticeBoard")
    public String showNoticeBoard() {
        return "notice-board";
    }

    @GetMapping("/writePostPage")
    public String showWritePostPage() {
        return "write-post-page";
    }
}
