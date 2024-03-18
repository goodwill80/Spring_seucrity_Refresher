package com.security.Lesson.on.spring.security.controller;

import com.security.Lesson.on.spring.security.model.Accounts;
import com.security.Lesson.on.spring.security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account")
    public ResponseEntity<Accounts> getAccountDetails(@RequestParam int id) {
        Accounts account = accountRepository.findByCustomerId(id);
        if(account != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(account);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
