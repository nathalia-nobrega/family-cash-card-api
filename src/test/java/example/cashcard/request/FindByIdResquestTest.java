package example.cashcard.request;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FindByIdResquestTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnACashCardWhenDataIsSaved() {
        ResponseEntity<String> res = restTemplate.getForEntity("/cashcards/1", String.class);
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(res.getBody());
        Number id = documentContext.read("$.id");
        Assertions.assertThat(id).isNotNull();
    }

    @Test
    void shouldNotReturnCorrectACashCardWithAnUnkownId() {
        ResponseEntity<String> res = restTemplate.getForEntity("/cashcards/2", String.class);

        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        Assertions.assertThat(res.getBody()).isBlank();
    }
}
