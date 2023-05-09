package example.cashcard.controllers;

import example.cashcard.model.cashcard.CashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashCardController {
    @GetMapping("/cashcards/{id}")
    public ResponseEntity<CashCard> findById(@PathVariable Long id) {

        return ResponseEntity.ok(null);
    }
}
