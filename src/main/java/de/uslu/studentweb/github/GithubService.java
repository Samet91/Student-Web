package de.uslu.studentweb.github;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {
    public Repository[] getRepositories(String githubUser) {
        String url = "https://api.github.com/users/" + githubUser + "/repos";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Repository[]> response = restTemplate.getForEntity(url, Repository[].class);

        return response.getBody();
    }
}
