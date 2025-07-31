package org.example.day04_bean_context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Day04BeanContextApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Day04BeanContextApplication.class, args);

        MessageService messageService = context.getBean(MessageService.class);

        String message = messageService.getMessage();

        System.out.println(message);

    }

}
