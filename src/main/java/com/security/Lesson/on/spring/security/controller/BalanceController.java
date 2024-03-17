package com.security.Lesson.on.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/balance")
    public String home() {
        return "Welcome to spring security balance controller";
    }
}
