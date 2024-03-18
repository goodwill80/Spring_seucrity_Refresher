package com.security.Lesson.on.spring.security.controller;

import com.security.Lesson.on.spring.security.model.Loans;
import com.security.Lesson.on.spring.security.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loan")
    public ResponseEntity<List<Loans>> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(loans);
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
