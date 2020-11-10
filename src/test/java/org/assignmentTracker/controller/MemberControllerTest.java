package org.assignmentTracker.controller;

import org.assignmentTracker.entity.Member;
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

import static org.junit.Assert.*;


/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Member controller class that Tsest of the class can  creat , read , update, read.
 * Date: 26 September 2020
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberControllerTest {

    private static Member member = MemberFactory.createMember(5);

    private static final String ADMIN_USERNAME = "lecturer";
    private static final String ADMIN_PASSWORD = "lecturer-password";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL=  "http://localhost:8080/vote";

    @Test
    public void a_create() {

        String url = baseURL + "create";
        ResponseEntity<Member> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, member,Member.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        member = postResponse.getBody();

        System.out.println("Created"+member);
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + member.getId();
        System.out.println(url);
        ResponseEntity<Member> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .getForEntity(url, Member.class);
        assertEquals(member.getId(), response.getBody().getId());
    }

    @Test
    public void c_update() {
        Member updated = new Member.Builder().copy(member).setAssignment_id(4).build();
        String url = baseURL + "update";
        ResponseEntity<Member> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, updated, Member.class);
        assertEquals(member.getId(), response.getBody().getId());
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
        String url = baseURL + "delete/" + member.getId();
        restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .delete(url);
    }
}