package org.assignmentTracker.controller.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class VoteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/vote";

    @Test
    public void create() {
        Vote vote = VoteFactory.createVote(UserFactory.createUser("Claude", "De-Tchambila",
                "Cla@5027", "christ.tchambila@email.com"));
        String url = baseUrl + "/create";
        ResponseEntity<Vote> postResponse = restTemplate.postForEntity(url, vote, Vote.class);
        assertNotNull(postResponse.getBody());

        System.out.println("Response body");
        System.out.println(postResponse.getBody());
        System.out.println("Response status code");
        System.out.println(postResponse.getStatusCodeValue());
    }

    @Test
    public void getAll() {
        String url = baseUrl + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}