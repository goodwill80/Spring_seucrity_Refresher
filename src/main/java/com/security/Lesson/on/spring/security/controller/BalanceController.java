package com.security.Lesson.on.spring.security.controller;

import com.security.Lesson.on.spring.security.model.AccountTransactions;
import com.security.Lesson.on.spring.security.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/balance")
    public ResponseEntity<List<AccountTransactions>> getBalanceDetails(@RequestParam int customerId) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
        if(accountTransactions != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(accountTransactions);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
