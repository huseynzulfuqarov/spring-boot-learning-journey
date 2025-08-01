package com.example.day05_dependency_injection.Dependency;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepository {
    public String getGreeting() {
        return "Hello from Repository";
    }
}