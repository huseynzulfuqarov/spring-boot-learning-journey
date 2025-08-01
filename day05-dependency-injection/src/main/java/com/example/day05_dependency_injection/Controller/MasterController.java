package com.example.day05_dependency_injection.Controller;

import com.example.day05_dependency_injection.Service.ConstructorInjectedService;
import com.example.day05_dependency_injection.Service.FieldInjectedService;
import com.example.day05_dependency_injection.Service.SetterInjectedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterController {

    private final ConstructorInjectedService constructorService;
    private final SetterInjectedService setterService;
    private final FieldInjectedService fieldService;

    public MasterController(ConstructorInjectedService constructorService,
                            SetterInjectedService setterService,
                            FieldInjectedService fieldService) {
        this.constructorService = constructorService;
        this.setterService = setterService;
        this.fieldService = fieldService;
    }

    @GetMapping("/constructor")
    public String testConstructorInjection() {
        return constructorService.sayGreeting();
    }

    @GetMapping("/setter")
    public String testSetterInjection() {
        return setterService.sayGreeting();
    }

    @GetMapping("/field")
    public String testFieldInjection() {
        return fieldService.sayGreeting();
    }
}