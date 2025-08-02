package org.example.day06_interfaces_qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    
    NotificationService notificationService;

    public NotificationController(@Qualifier("sms_notification") NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @GetMapping("/notify")
    public String sendNotification(@RequestParam String message) {
        return notificationService.sendNotification(message);
    }
}
