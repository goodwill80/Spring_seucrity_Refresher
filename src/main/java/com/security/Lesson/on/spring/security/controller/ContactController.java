package com.security.Lesson.on.spring.security.controller;

import com.security.Lesson.on.spring.security.model.Contact;
import com.security.Lesson.on.spring.security.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        Contact saved = contactRepository.save(contact);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saved);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        String randomNumber = String.valueOf(ranNum);
        return "SR"+randomNumber;
    }
}
