package example.cashcard.entities.cashcard;

import jakarta.persistence.Id;

public record CashCard(@Id Long id, Double amount) {
}
