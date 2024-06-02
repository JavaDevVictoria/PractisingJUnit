package org.example;

public class NotificationService {

    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean notifyUser(String email, String message) {
        return emailService.sendEmail(email, "Notification", message);
    }
}

