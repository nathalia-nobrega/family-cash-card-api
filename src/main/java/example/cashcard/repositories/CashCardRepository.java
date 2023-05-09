package example.cashcard.repositories;

import example.cashcard.entities.cashcard.CashCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface CashCardRepository extends CrudRepository<CashCard, Long> {
}
