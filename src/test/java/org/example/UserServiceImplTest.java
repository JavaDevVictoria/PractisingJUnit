package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        
        userServiceImpl.assignPassword(mockedAccountUser);

        verify(mockedUserDAO,times(1)).updateUser(mockedAccountUser);
    }

}