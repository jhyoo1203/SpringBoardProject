package kr.ac.gwnu.boardboard.controller;

import kr.ac.gwnu.boardboard.dto.PostDTO;
import kr.ac.gwnu.boardboard.dto.UserDTO;

import kr.ac.gwnu.boardboard.entity.freeBoard.FreeBoardPost;
import kr.ac.gwnu.boardboard.service.FreeBoardService;
import kr.ac.gwnu.boardboard.service.NoticeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final FreeBoardService freeBoardService;
    private final NoticeBoardService noticeBoardService;

    @Autowired
    public HomeController(FreeBoardService freeBoardService, NoticeBoardService noticeBoardService) {
        this.freeBoardService = freeBoardService;
        this.noticeBoardService = noticeBoardService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "join";
    }

    @GetMapping("/freeBoard")
    public String showFreeBoard(Model model) {
        model.addAttribute("latestFreeBoardPosts", freeBoardService.getLatestFreeBoardPosts(30).orElse(null));
        return "free-board";
    }

    @GetMapping("/noticeBoard")
    public String showNoticeBoard(Model model) {
        model.addAttribute("latestNoticeBoardPosts", noticeBoardService.getLatestNoticeBoardPosts(30).orElse(null));
        return "notice-board";
    }

    @GetMapping("/writePostPage")
    public String showWritePostPage() {
        return "write-post-page";
    }
}
