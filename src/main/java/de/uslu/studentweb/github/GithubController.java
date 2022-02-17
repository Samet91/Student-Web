package de.uslu.studentweb.github;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/{githubUser}")
    public String[] getRepositoryNames(@PathVariable String githubUser) {
        Repository[] repositories = githubService.getRepositories(githubUser);

        String[] repoNames = Arrays.stream(repositories)
                .map(Repository::getName)
                .toArray(String[]::new);

         return repoNames;
    }
}
