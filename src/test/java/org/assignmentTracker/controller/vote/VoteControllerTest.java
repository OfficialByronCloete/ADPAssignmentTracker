package org.assignmentTracker.controller.vote;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class VoteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/vote";
    private static Vote vote;

    @Test
    public void a_create() {
        Vote newVote = VoteFactory.createVote(UserFactory.createUser("Claude", "De-Tchambila",
                "12312", "christ.tchambila@email.com"));
        String url = baseUrl + "/create";
        ResponseEntity<Vote> postResponse = restTemplate.postForEntity(url, newVote, Vote.class);

        assertNotNull(postResponse.getBody());
        vote = postResponse.getBody();

        System.out.println("Create vote");

        System.out.println("Response body");
        System.out.println(postResponse.getBody());
        System.out.println("Response status code");
        System.out.println(postResponse.getStatusCodeValue());
    }

    @Test
    public void b_read() {
        int id = vote.getId();
        String url = baseUrl + "/read/" + id;

        ResponseEntity<Vote> getResponse = restTemplate.getForEntity(url, Vote.class);

        assertNotNull(getResponse.getBody());

        System.out.println("Read vote");
        System.out.println(getResponse.getBody());
        System.out.println(getResponse.getStatusCodeValue());
    }

    @Test
    public void c_update() {
        String url = baseUrl + "/update";
        User user = vote.getVoter();
        vote.setVoter(UserFactory.createUser("Melody", "Bell", "123123", "bell@email.com"));
        restTemplate.put(url, vote);

        assertNotSame(user, vote.getVoter());
    }

    @Test
    public void e_delete() {
        String url = baseUrl + "/delete/" + vote.getId();
        restTemplate.delete(url);

        ResponseEntity<List> response = restTemplate.getForEntity(baseUrl + "/all", List.class);

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Get all votes");
        System.out.println(response.getBody());
    }
}