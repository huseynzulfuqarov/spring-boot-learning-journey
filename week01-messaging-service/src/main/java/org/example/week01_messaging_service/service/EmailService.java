package org.example.week01_messaging_service.service;

import org.springframework.stereotype.Service;

@Service("email_service")
public class EmailService implements MessageService {

    @Override
    public String sendMessage(String to, String message) {
        return String.format("Email sent to %s with message: \'%s\'. Message ID: 12345", to, message);
    }

    @Override
    public String checkStatus(String messageId) {
        return String.format("Email with ID %s was delivered.", messageId);
    }
}