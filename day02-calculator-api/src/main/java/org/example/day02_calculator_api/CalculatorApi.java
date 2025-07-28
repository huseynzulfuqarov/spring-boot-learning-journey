package org.example.day02_calculator_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorApi {

    @GetMapping("/add")
    public double add(@RequestParam(name = "aa") double a, @RequestParam(name = "bb") double b) {
        return a + b;
    }

    @GetMapping("/sub")
    public double sub(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/mul")
    public double mul(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/div")
    public double div(@RequestParam double a, @RequestParam double b) {
        return a / b;
    }

    @GetMapping("/repeat")
    public String word(@RequestParam String word) {
        return (word + " ").repeat(10000000);
    }

    @GetMapping("/diamond")
    public String drawDiamond(@RequestParam int n) {
        if (n > 100) {
            return "You can use max 100";
        } else if (n <= 0) {
            return "You can use min 1";
        }
        StringBuilder builder = new StringBuilder();
        int m = n - 1;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 2 * i + 1; k++) {
                builder.append("*");
            }
            builder.append("<br>");
        }
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < 2 * m - i * 2 - 1; k++) {
                builder.append("*");
            }
            builder.append("<br>");
        }
        return builder.toString();
    }
}