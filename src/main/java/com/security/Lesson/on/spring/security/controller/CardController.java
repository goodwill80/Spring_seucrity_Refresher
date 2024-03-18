package com.security.Lesson.on.spring.security.controller;

import com.security.Lesson.on.spring.security.model.Cards;
import com.security.Lesson.on.spring.security.repository.CardsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    private CardsRepository cardsRepository;

    @GetMapping("/card")
    public ResponseEntity<List<Cards>> getCardDetails(@RequestParam int customerId) {
        List<Cards> cards = cardsRepository.findByCustomerId(customerId);
        if(cards != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(cards);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
