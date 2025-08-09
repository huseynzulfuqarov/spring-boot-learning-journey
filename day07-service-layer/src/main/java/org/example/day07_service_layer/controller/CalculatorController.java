package org.example.day07_service_layer.controller;

import org.example.day07_service_layer.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public double addNumbers(@RequestParam double a, @RequestParam double b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/sub")
    public double subNumbers(@RequestParam double a, @RequestParam double b) {
        return calculatorService.sub(a, b);
    }

    @GetMapping("/mul")
    public double mulNumbers(@RequestParam double a, @RequestParam double b) {
        return calculatorService.mul(a, b);
    }

    @GetMapping("/div")
    public double divNumbers(@RequestParam double a, @RequestParam double b) {
        return calculatorService.div(a, b);
    }
}
