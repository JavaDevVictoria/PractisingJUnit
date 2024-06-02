package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    private NotificationService notificationService;

    @Mock
    private EmailService mockedEmailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        notificationService = new NotificationService(mockedEmailService);
    }

    @Test
    void testEmailSentSuccessfully() {
        String email = "freddy@gmail.com";
        String message = "Hello. How are you doing?";

        when(mockedEmailService.sendEmail(email, "Notification", message)).thenReturn(true);

        boolean result = notificationService.notifyUser(email, message);

        assertTrue(result);
        verify(mockedEmailService,times(1)).sendEmail(email, "Notification", message);
    }

    @Test
    void testEmailSendingFailed() {
        String email = "freddy@gmail.com";
        String message = "Hello. How are you doing?";

        when(mockedEmailService.sendEmail(email, "Notification", message)).thenReturn(false);

        boolean result = notificationService.notifyUser(email, message);

        assertFalse(result);
        verify(mockedEmailService,times(1)).sendEmail(email, "Notification", message);
    }


}