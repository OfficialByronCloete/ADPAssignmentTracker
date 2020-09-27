package org.assignmentTracker.controller.admin;

import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.AdminFactory;
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

import static org.assignmentTracker.factory.UserFactory.createUser;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/*
@author Brandon Villet
StudNo: 214056791
Date: 27 September 2020
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static Admin admin;
    private final String baseURL = "http://localhost:8080/admin";

    @Test
    public void a_create(){
          User user = createUser("Brandon", "Villet", "pass", "villetbrandon@gmail.com");
          Admin newAdmin = AdminFactory.createAdmin(user, null);
        String url = baseURL + "/create";
        ResponseEntity<Admin> response = restTemplate.postForEntity(url, newAdmin, Admin.class);

        assertNotNull(response.getBody());
        admin = response.getBody();

        System.out.println("Response body");
        System.out.println(response.getBody());
        System.out.println("Response status code");
        System.out.println(response.getStatusCodeValue());
    }

    @Test
    public void b_read(){
        int id = admin.getId();
        String url = baseURL + "/read" + id;

        ResponseEntity<Admin> getResponse = restTemplate.getForEntity(url, Admin.class);

        assertNotNull(getResponse.getBody());

        System.out.println("Read User");
        System.out.println(getResponse.getBody());
        System.out.println(getResponse.getStatusCodeValue());
    }

    @Test
    public void c_update(){
        String url = baseURL + "/update";
        String oldName = admin.getUser().getName();
        User userUpdated = new User.Builder().copy(admin.getUser()).setName("John").build();
        Admin updated = new Admin.Builder().copy(admin).setUser(userUpdated).build();
        restTemplate.put(url, admin);

        assertNotEquals(admin.getUser().getName(), oldName);

    }

    public void e_delete(){
        String url = baseURL + "/delete/" + admin.getId();
        restTemplate.delete(url);

        ResponseEntity<List> response = restTemplate.getForEntity(baseURL + "/all", List.class);

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Get all ");
        System.out.println(response.getBody());
    }

}