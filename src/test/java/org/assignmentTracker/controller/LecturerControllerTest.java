package org.assignmentTracker.controller;

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.entity.Member;
import org.assignmentTracker.factory.LectureFactory;
import org.assignmentTracker.factory.MemberFactory;
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

import static org.junit.Assert.*;

/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Lecture controller class that Tsest of the class can  creat , read , update, read.
 * Date: 26 September 2020
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LecturerControllerTest {

    private static Lecture lecture = LectureFactory.newLecture("Justin","Kokolo","justin@.com","096498848","9");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL=  "http://localhost:8080/vote";

    private static final String ADMIN_USERNAME = "lecturer";
    private static final String ADMIN_PASSWORD = "lecturer-password";

    @Test
    public void a_create() {

        String url = baseURL + "create";
        ResponseEntity<Lecture> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, lecture, Lecture.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        lecture = postResponse.getBody();

        System.out.println("Created"+ lecture);
        assertEquals(lecture.getId(),postResponse.getBody().getId());


    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + lecture.getId();
        System.out.println(url);
        ResponseEntity<Lecture> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .getForEntity(url, Lecture.class);
        assertEquals(lecture.getId(), response.getBody().getId());


    }

    @Test
    public void c_update() {
        Lecture updated = new Lecture.Builder().copy(lecture).setName("Kevin").build();
        String url = baseURL + "update";
        ResponseEntity<Lecture> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, updated, Lecture.class);
        assertEquals(lecture.getId(), response.getBody().getId());


    }

    @Test
    public void d_getAll() {

        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());


    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + lecture.getId();
        restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).delete(url);

        ResponseEntity<List> response = restTemplate.getForEntity(baseURL + "/all", List.class);
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());


    }
}