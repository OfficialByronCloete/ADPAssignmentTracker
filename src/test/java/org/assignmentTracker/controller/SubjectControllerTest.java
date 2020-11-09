package org.assignmentTracker.controller;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Test class for SubjectController
 */

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.SubjectFactory;
import org.junit.Assert;
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

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class SubjectControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/subject";
    private static Subject subject;
    private static String userName = "Byron";
    private static String password = "password";


    @Test
    public void a_create(){

        Date dates = new Date();
        Subject newSubject = SubjectFactory.createSubject("Applications Development Theory","ADT(362S)","Agile Development",dates);
        String url = baseURL + "/create";
        ResponseEntity<Subject> postResponse = restTemplate.
                withBasicAuth(userName, password).
                postForEntity(url, newSubject, Subject.class);
        assertNotNull(postResponse.getBody());
        subject = postResponse.getBody();
        System.out.println("Create subject");
        System.out.println(postResponse.getBody());


    }


    @Test
    public void b_read(){
        int id = subject.getId();
        String url = baseURL + "/read/" + id;
        ResponseEntity<Subject> getResponse = restTemplate.getForEntity(url, Subject.class);
        assertNotNull(getResponse.getBody());
        System.out.println("Read subject");
        System.out.println(getResponse.getBody());
    }


    @Test
    public void c_update(){

        Subject updated = new Subject.Builder().copy(subject).setName("Electives").setCode("ICE362S").setLecture("ChildComponents 101").setDate(new Date()).build();
        String url = baseURL + "updated";
        System.out.println("URL"+url);
        System.out.println("Post data"+ updated);
        restTemplate.withBasicAuth(userName, password).put(url, subject);
        Assert.assertNotSame(subject,subject.getId());

    }


    public void e_delete(){

        String url = baseURL + "/delete/"+subject.getId();
        System.out.println("URL"+url);
        restTemplate.delete(url);
        ResponseEntity<List> response = restTemplate.withBasicAuth(userName, password).
                getForEntity(baseURL+ "/all",List.class);
        System.out.println(response.getBody());

    }


    @Test
    public void d_getall(){
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity= new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(userName, password).
                exchange(url,HttpMethod.GET,entity, String.class);
        System.out.println("All subjects displayed");
        System.out.println(response.getBody());

    }

}