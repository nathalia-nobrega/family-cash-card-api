package example.cashcard;

import example.cashcard.model.cashcard.CashCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CashCardApplicationTests {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    public void cashCardSerializationTest() throws IOException {
        File file = new File("C:\\Users\\Nathalia Nóbrega\\dev\\projects\\cashcard\\src\\test\\resources\\example\\cashcard\\expected.json");
        CashCard cashCard = new CashCard(99L, 123.45);
        assertThat(json.write(cashCard)).isStrictlyEqualToJson(file);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
                .isEqualTo(123.45);
    }

    @Test
    public void cashCardDeserializationTest() throws IOException {
        CashCard cashCard = new CashCard(1000L, 67.89);
        String expected = """
                {
                    "id" : 99,
                    "amount" : 123.45
                }
                """;

        // Should work
        assertThat(json.parse(expected)).isNotEqualTo(cashCard);

        // Should work
        assertThat(json.parseObject(expected).id()).isNotEqualTo(cashCard.id());

        // Should fail
        assertThat(json.parseObject(expected).amount()).isEqualTo(cashCard.amount());


    }
}