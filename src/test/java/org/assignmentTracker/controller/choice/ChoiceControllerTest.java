package org.assignmentTracker.controller.choice;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.repository.choice.impl.ChoiceRepository;
import org.assignmentTracker.service.choice.impl.ChoiceServiceImpl;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Author Anganathi Ngodwane 217078907
 * @Date: 27 September 2020
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChoiceControllerTest {

    List<Vote> votes = new ArrayList<>();

    public ChoiceControllerTest(){
        votes.add(VoteFactory.createVote(UserFactory.createUser("Kruben", "Naidoo", "ilovecode", "knaidoo@cput.ac.za")));
    }
    Choice choice = ChoiceFactory.createChoice("ICE362-Python", votes);

    @Autowired
    TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/choice";

    @Test
    public void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Choice> responseEntity = restTemplate.postForEntity(url, choice, Choice.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println("Post: "+ responseEntity.getBody().getId());
    }

    @Test
    public void c_read() {
        String url = baseUrl + "/read/" + 427060491; //copy id from the console output of c_getAll and paste here to test
        ResponseEntity<Choice> responseEntity = restTemplate.getForEntity(url, Choice.class);
        assertEquals(427060491, responseEntity.getBody().getId());
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println(url.toString());
    }

    @Test
    public void b_getAll() {
        String url = baseUrl + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Set> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Set> response = restTemplate.exchange(url, HttpMethod.GET, entity, Set.class);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println(response.getBody().toString()+"\n");

    }

    @Test
    public void delete() {
        String url = baseUrl + "/delete/"  + 427060491; //copy the id from getAll and paste here to test
        restTemplate.delete(url);
        System.out.println(url.toString());
    }
}