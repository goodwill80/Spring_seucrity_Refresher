package com.security.Lesson.on.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/card")
    public String home() {
        return "Welcome to spring security card controller";
    }
}
