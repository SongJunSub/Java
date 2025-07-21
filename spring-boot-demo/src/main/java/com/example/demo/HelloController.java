package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot with Lombok!";
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private int age;
}
