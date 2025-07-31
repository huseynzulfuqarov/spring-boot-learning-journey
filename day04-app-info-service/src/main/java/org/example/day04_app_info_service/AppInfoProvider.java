package org.example.day04_app_info_service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppInfoProvider {
    public String getAppName() {
        return "Awesome Application";
    }

    public String getAppVersion() {
        return "2.1.0-RELEASE";
    }

    public Map<String, String> getAuthorInfo() {
        Map<String, String> author = new HashMap<>();
        author.put("name", "Huseyn Zulfuqarov");
        author.put("email", "hzulfuqarov.dev@gmail.com");
        author.put("role", "Developer");
        return author;
    }
}
