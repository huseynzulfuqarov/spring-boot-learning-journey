package com.example.day05_dependency_injection.Service;

import com.example.day05_dependency_injection.Dependency.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjectedService {

    @Autowired
    private GreetingRepository greetingRepository;

    public String sayGreeting() {
        return "Field Injection: " + greetingRepository.getGreeting();
    }
}