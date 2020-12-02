package org.assignmentTracker.controller.choice;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
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
        votes.add(VoteFactory.createVote(UserFactory.createUser("Gillian","Khan","kang1230","khang@cput.ac.za")));
    }
    Choice c = new Choice.Builder().setName("Software Engineering").setVotes(votes).build();
    Choice choice = ChoiceFactory.createChoice(c.getName(), c.getVotes());

    @Autowired
    TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/choice";

    private static final String ADMIN_USERNAME = "Byron";
    private static final String ADMIN_PASSWORD = "password";

    private static final String USER_USERNAME = "Robyn";
    private static final String USER_PASSWORD = "wordpass";

    @Test
    public void a_create() {
        try{
            String url = baseUrl + "/create";
            ResponseEntity<Choice> responseEntity = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).postForEntity(url, choice, Choice.class);
            assertEquals(200, responseEntity.getStatusCodeValue());
            //  System.out.println("Post: "+ responseEntity.getBody().getId());
            System.out.println(responseEntity.toString());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void c_read() {
        String url = baseUrl + "/read/" + 0; //copy id from the console output of c_getAll and paste here to test
        ResponseEntity<Choice> responseEntity = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).getForEntity(url, Choice.class);
        assertEquals(0, responseEntity.getBody().getId());
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println(url.toString());
    }

    @Test
    public void b_getAll() {
        String url = baseUrl + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Set> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Set> response = restTemplate.withBasicAuth(USER_USERNAME,USER_PASSWORD).exchange(url, HttpMethod.GET, entity, Set.class);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println(response.getBody().toString()+"\n");

    }

    @Test
    public void delete() {
        String url = baseUrl + "/delete/"  + 0; //copy the id from getAll and paste here to test
        restTemplate.delete(url);
        System.out.println(url.toString());
    }
}