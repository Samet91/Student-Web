package de.uslu.studentweb.github;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubControllerTestMock {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private GithubService githubService;

    @Test
    void shouldRetrieveRepositoryNames() {

        Repository repository1 = new Repository();
        repository1.setName("Repository 1");

        Repository repository2 = new Repository();
        repository2.setName("Repository 2");

        Repository repository3 = new Repository();
        repository3.setName("Repository 3");

        Repository[] repositories = new Repository[3];
        repositories[0] = repository1;
        repositories[1] = repository2;
        repositories[2] = repository3;

        String[] expectedNames = new String[3];
        expectedNames[0] = "Repository 1";
        expectedNames[1] = "Repository 2";
        expectedNames[2] = "Repository 3";

        when(githubService.getRepositories("samet91")).thenReturn(repositories);

        ResponseEntity<String[]> response = restTemplate.getForEntity("/github/samet91", String[].class);
        assertArrayEquals(expectedNames, response.getBody());
    }
}