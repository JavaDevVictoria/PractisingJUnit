package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserServiceImpl userServiceImpl;

    @Mock
    private UserDAO mockedUserDAO;

    @Mock
    private SecurityService mockedSecurityService;

    @Mock
    private AccountUser mockedAccountUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userServiceImpl = new UserServiceImpl(mockedUserDAO, mockedSecurityService);
    }

    @Test
    void testUserGetsPassword() throws Exception {
        String password = "password";
        String hashedPassword = "hashedPassword";

        when(mockedAccountUser.getPassword()).thenReturn(password);
        when(mockedSecurityService.md5(password)).thenReturn((hashedPassword));

        userServiceImpl.assignPassword(mockedAccountUser);

        verify(mockedAccountUser, times(1)).setPassword(hashedPassword);
        verify(mockedUserDAO,times(1)).updateUser(mockedAccountUser);
    }

}