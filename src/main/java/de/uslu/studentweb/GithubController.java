package de.uslu.studentweb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/github")
public class GithubController {

    @GetMapping("/githubUser")
    public String[] getRepositoryNames(@PathVariable String githubUser) {
        // Ermitteln der Daten von GitHub. Dafür wird die URL aufgebaut und mit Hilfe des RestTemplates ein get-request
        // an die GitHub API geschickt.
        // Als Response-Body erwarte ich ein Array von Repository Objekten. Die Klasse Repository habe ich selber
        // geschrieben. Sie beinhaltet nur ein Attribute name und getter und setter. Alle anderen Properties in der
        // Response von GitHub interessieren mich nicht.

        String url = "https://api.github.com/users/?????/repos";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Repository[]> response = restTemplate.getForEntity(url, Repository[].class);

        // ich hole mir den Response-Body aus der Response von Github.
        Repository[] repositories = response.getBody();
        // Ich iteriere über die Repository Objecte aus der Response von GitHub und speichere den Namen im Array
        // repositoryNames. Das Array wird dann auch returned.
        String[] repositoryNames = new String[repositories.length];
        for (int i=0; i < repositoryNames.length; i++) {
            repositoryNames[i] = repositories[i].getName();
        }
        return repositoryNames;
    }
}
