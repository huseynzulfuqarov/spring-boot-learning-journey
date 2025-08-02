package org.example.day06_interfaces_qualifiers;

import org.springframework.stereotype.Component;

@Component("sms_notification")
public class SmsService implements NotificationService {

    @Override
    public String sendNotification(String message) {
        return "SMS: " + message;
    }
}
