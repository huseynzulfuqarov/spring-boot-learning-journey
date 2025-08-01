package com.example.day05_dependency_injection.Service;

import com.example.day05_dependency_injection.Dependency.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedService {
    private final GreetingRepository greetingRepository;

    public ConstructorInjectedService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String sayGreeting() {
        return "Constructor Injection: " + greetingRepository.getGreeting();
    }
}