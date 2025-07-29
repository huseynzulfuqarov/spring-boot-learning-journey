package org.example.day03_path_variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/users/{userId}/info/{dataType}")
    public String getUserSpecificInfo(@PathVariable Long userId, @PathVariable String dataType) {
        if(userId.equals(1L) && dataType.equals("age")) {
            return "Hello, David! Your " + dataType + " is 25.";
        }
        else if(userId.equals(2L) && dataType.equals("weight")) {
            return "Hello, John! Your " + dataType + " is 75.";
        }
        else {
            return "User with ID " + userId + " and data type '" + dataType + "' not found or has no specific info.";
        }
    }
}