package com.security.Lesson.on.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String home() {
        return "Welcome to spring security contact controller";
    }
}
