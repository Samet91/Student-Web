package de.uslu.studentweb.github;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        String[] repositoryNames = new String[repositories.length];
        for (int i=0; i < repositoryNames.length; i++) {
            repositoryNames[i] = repositories[i].getName();
        }
        return repositoryNames;
    }
}
