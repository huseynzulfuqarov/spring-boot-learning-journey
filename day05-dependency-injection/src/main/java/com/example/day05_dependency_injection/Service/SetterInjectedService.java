package com.example.day05_dependency_injection.Service;

import com.example.day05_dependency_injection.Dependency.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterInjectedService {
    private GreetingRepository greetingRepository;

    @Autowired
    public void setGreetingRepository(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String sayGreeting() {
        return "Setter Injection: " + greetingRepository.getGreeting();
    }
}
