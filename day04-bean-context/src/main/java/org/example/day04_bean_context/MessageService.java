package org.example.day04_bean_context;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    public String getMessage() {
        return "Hello World form Spring Bean.";
    }
}
