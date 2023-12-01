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
        List<PostDTO> freeBoardPosts = Arrays.asList(
                new PostDTO("자유게시판 제목 1", "자유게시판 내용이 여기에 들어갑니다."),
                new PostDTO("자유게시판 제목 2", "자유게시판 내용이 여기에 들어갑니다."),
                new PostDTO("자유게시판 제목 3", "자유게시판 내용이 여기에 들어갑니다.")
        );

        List<PostDTO> noticeBoardPosts = Arrays.asList(
                new PostDTO("공지사항 제목 1", "공지사항 내용이 여기에 들어갑니다."),
                new PostDTO("공지사항 제목 2", "공지사항 내용이 여기에 들어갑니다."),
                new PostDTO("공지사항 제목 3", "공지사항 내용이 여기에 들어갑니다.")
        );

        model.addAttribute("freeBoardPosts", freeBoardPosts);
        model.addAttribute("noticeBoardPosts", noticeBoardPosts);

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
}
