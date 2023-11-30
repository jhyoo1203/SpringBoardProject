package kr.ac.gwnu.boardboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.gwnu.boardboard.dto.UserDTO;
import kr.ac.gwnu.boardboard.entity.User;
import kr.ac.gwnu.boardboard.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(UserDTO userDTO, Model model, HttpSession session) {
        User user = userService.authenticateUser(userDTO);

        if (user != null) {
            session.setAttribute("user", user.getNickname());  // 세션에도 사용자 정보 추가
        return "redirect:/";
        } else {
            model.addAttribute("loginSuccess", false);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        // 세션을 무효화하고 로그아웃
        session.invalidate();

        // 로그아웃이 완료되면 홈페이지로 리다이렉트
        return "redirect:/";
    }
}
