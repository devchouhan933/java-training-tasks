package com.company.rest.example;

import com.company.day14.person.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Example {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Example.class, args);

    }
}
