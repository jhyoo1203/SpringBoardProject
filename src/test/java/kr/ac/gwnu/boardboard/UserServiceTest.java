package kr.ac.gwnu.boardboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kr.ac.gwnu.boardboard.dto.UserDTO;
import kr.ac.gwnu.boardboard.entity.User;
import kr.ac.gwnu.boardboard.repository.UserRepository;
import kr.ac.gwnu.boardboard.service.UserServiceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("YooJaeHyeon");
        userDTO.setNickname("jhyoo");
        userDTO.setPassword("1234");
        User user = new User();
        user.setUsername("YooJaeHyeon");
        user.setNickname("jhyoo");
        user.setPassword("1234");

        when(userRepository.save(any(User.class))).thenReturn(user);

        assertEquals(user, userService.saveUser(userDTO).orElse(null));

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setUsername("YooJaeHyeon");
        user.setNickname("jhyoo");
        user.setPassword("1234");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertEquals(user, userService.getUserById(userId).orElse(null));

        verify(userRepository, times(1)).findById(userId);
    }
}
