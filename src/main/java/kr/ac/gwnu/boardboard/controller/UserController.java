package kr.ac.gwnu.boardboard.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import kr.ac.gwnu.boardboard.dto.UserDTO;
import kr.ac.gwnu.boardboard.entity.User;
import kr.ac.gwnu.boardboard.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "회원가입에 실패하였습니다.");
            return "join";
        }

        Optional<User> savedUser = userService.saveUser(userDTO);

        if (savedUser.isPresent()) {
            model.addAttribute("message", "회원가입이 성공적으로 완료되었습니다.");
            return "redirect:/";
        } else {
            model.addAttribute("message", "회원가입에 실패하였습니다.");
            return "join";
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

}