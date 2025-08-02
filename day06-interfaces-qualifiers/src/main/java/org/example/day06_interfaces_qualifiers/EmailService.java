package org.example.day06_interfaces_qualifiers;

import org.springframework.stereotype.Component;

@Component("email_notification")
public class EmailService implements NotificationService {

    @Override
    public String sendNotification(String message) {
        return "Email: " + message;
    }
}
