package kr.ac.gwnu.boardboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.gwnu.boardboard.dto.UserDTO;
import kr.ac.gwnu.boardboard.entity.User;
import kr.ac.gwnu.boardboard.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> saveUser(UserDTO userDTO) {
        // UserDTO에서 User 엔티티로 변환
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setNickname(userDTO.getNickname());
        user.setPassword(userDTO.getPassword());

        // User 엔티티 저장
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        // 사용자 ID로 사용자 조회
        return userRepository.findById(userId);
    }

    @Override
    public User authenticateUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname).orElse(null);
    }

}
