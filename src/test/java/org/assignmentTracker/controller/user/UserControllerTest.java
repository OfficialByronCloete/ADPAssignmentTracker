package org.assignmentTracker.controller.user;


import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
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

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/*
@author Byron Cloete
StudNo: 214189872
Date: 26 September 2020
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static User user;
    private final String baseURL = "http://localhost:8080/user";
    private static String userName = "Byron";
    private static String password = "password";

    @Test
    public void a_create(){
        User newUser = UserFactory.createUser("Byron", "Cloete", "password", "byroncloete7@gmail.com");
        String url = baseURL + "/create";
        ResponseEntity<User> response = restTemplate.
                withBasicAuth(userName, password).
                postForEntity(url, newUser, User.class);

        assertNotNull(response.getBody());
        user = response.getBody();

        System.out.println("Response body");
        System.out.println(response.getBody());
        System.out.println("Response status code");
        System.out.println(response.getStatusCodeValue());
    }

    @Test

    public void b_read(){
        int id = user.getID();
        String url = baseURL + "/read" + id;

        ResponseEntity<User> getResponse = restTemplate.withBasicAuth(userName, password).getForEntity(url, User.class);

        assertNotNull(getResponse.getBody());

        System.out.println("Read User");
        System.out.println(getResponse.getBody());
        System.out.println(getResponse.getStatusCodeValue());
    }

    @Test
    public void c_update(){
        String url = baseURL + "/update";
        String oldPassword = user.getName();
        user = new User.Builder().copy(user).setPassword("mynewpassword").build();
        restTemplate.withBasicAuth(userName, password).put(url, user);

        assertNotEquals(user.getPassword(), oldPassword);

    }

    public void e_delete(){
        String url = baseURL + "/delete/" + user.getID();
        restTemplate.delete(url);

        ResponseEntity<List> response = restTemplate
                .withBasicAuth(userName, password)
                .getForEntity(baseURL + "/all", List.class);

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(userName, password)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Get all assignments");
        System.out.println(response.getBody());
    }

}
