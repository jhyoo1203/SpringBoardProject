package kr.ac.gwnu.boardboard.service;

import kr.ac.gwnu.boardboard.dto.UserDTO;
import kr.ac.gwnu.boardboard.entity.User;
import java.util.Optional;


public interface UserService {
    Optional<User> saveUser(UserDTO userDTO);
    Optional<User> getUserById(Long userId);
    User authenticateUser(UserDTO userDTO);

    User getUserByNickname(String nickname);
}
