package de.uslu.studentweb.github;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldRetrieveRepositoryNames() {

         ResponseEntity<String[]> response = restTemplate.getForEntity("/github/samet91", String[].class);
         assertTrue(response.getBody().length > 0);
     }

}