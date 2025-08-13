package org.example.week01_messaging_service.service;

import org.springframework.stereotype.Service;

@Service("sms_service")
public class SmsService implements MessageService {

    @Override
    public String sendMessage(String to, String message) {
        return String.format("SMS sent to %s with text: \'%s\'. Message ID: 67890", to, message);
    }

    @Override
    public String checkStatus(String messageId) {
        return String.format("SMS with ID %s is pending.", messageId);
    }
}
