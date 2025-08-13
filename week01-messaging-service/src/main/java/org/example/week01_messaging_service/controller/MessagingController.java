package org.example.week01_messaging_service.controller;

import org.example.week01_messaging_service.service.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

    private final MessageService emailService;
    private final MessageService smsService;

    public MessagingController(@Qualifier("email_service") MessageService emailService,
                               @Qualifier("sms_service") MessageService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @GetMapping("/send/{channel}")
    public String sendMessage(@PathVariable String channel,
                              @RequestParam String to,
                              @RequestParam String message) {

        if (channel.equalsIgnoreCase("email")) {
            return emailService.sendMessage(to, message);
        } else if (channel.equalsIgnoreCase("sms")) {
            return smsService.sendMessage(to, message);
        } else {
            return "Error: Unknown channel specified.";
        }
    }

    @GetMapping("/status/{channel}/{messageId}")
    public String checkMessageStatus(@PathVariable String channel, @PathVariable String messageId) {
        if (channel.equalsIgnoreCase("email")) {
            return emailService.checkStatus(messageId);
        } else if (channel.equalsIgnoreCase("sms")) {
            return smsService.checkStatus(messageId);
        } else {
            return "Error: Unknown channel specified.";
        }
    }
}