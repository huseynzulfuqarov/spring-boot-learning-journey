package org.example.week01_messaging_service.service;

public interface MessageService {

    String sendMessage(String to, String message);

    String checkStatus(String messageId);
}
