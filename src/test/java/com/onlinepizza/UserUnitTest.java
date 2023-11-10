package com.onlinepizza;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.entity.User;
import com.onlinepizza.exception.UserManagementException;
import com.onlinepizza.repository.UserRepository;
import com.onlinepizza.serviceimp.IUserServiceImp;

@SpringBootTest
public class UserUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private IUserServiceImp userService;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterUser() throws UserManagementException {
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setUserRole("USER");

        when(userRepository.save(user)).thenReturn(user);

        UserDTO userDTO = userService.registerUser(user);

        assertEquals(user.getUserId(), userDTO.getUserId());
        assertEquals(user.getUserName(), userDTO.getUserName());
        assertEquals(user.getUserRole(), userDTO.getUserRole());
    }

    @Test
    void testRegisterUserInvalidUser() {
        User user = new User();

        when(userRepository.save(user)).thenReturn(null);

        assertThrows(UserManagementException.class, () -> userService.registerUser(user));
    }

    @Test
    void testSignIn() throws UserManagementException {
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setUserRole("USER");
        user.setPassword("password");

        when(userRepository.findByUserName("testUser")).thenReturn(user);

        assertThrows(UserManagementException.class, () -> userService.signIn("testUser", "wrongPassword"));
    }


}

