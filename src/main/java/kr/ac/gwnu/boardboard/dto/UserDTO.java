package kr.ac.gwnu.boardboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String nickname;
    private String password;
    private String confirmPassword;
}