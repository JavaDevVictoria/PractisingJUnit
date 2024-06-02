package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private User user;

    @Mock
    private UserRepository mockedUserRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(mockedUserRepository);
        user = new User(12345, "John Doe", "john.doe@example.com"); // Initialize the user object
    }

    @Test
    void testGetUserDetails() {
        int userId = 12345;

        when(mockedUserRepository.findUserById(userId)).thenReturn(user);

        User actualUser =  userService.getUserDetails(userId);

        assertEquals(user,actualUser);
        verify(mockedUserRepository, times(1)).findUserById(userId);
    }

    @Test
    void testRegisterUser() {
        userService.registerUser(user);

        verify(mockedUserRepository, times(1)).saveUser(user);
    }

}