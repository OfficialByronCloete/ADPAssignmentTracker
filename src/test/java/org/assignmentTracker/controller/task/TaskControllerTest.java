package org.assignmentTracker.controller.task;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.entity.Student;
import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.entity.Task;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.factory.TaskFactory;
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

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskControllerTest {

    private static final String ADMIN_USERNAME = "lecturer";
    private static final String ADMIN_PASSWORD = "lecturer-password";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/task";

    private static Task task = TaskFactory.newTask(1, 215169751, 6);

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Task> postResponse = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).postForEntity(url, task, Task.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        task = postResponse.getBody();
        System.out.println("Created " + task);
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + task.getTaskId();
        System.out.println(url);
        ResponseEntity<Task> getResponse = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).getForEntity(url, Task.class);
        assertEquals(task.getTaskId(), getResponse.getBody().getTaskId());
    }

    @Test
    public void c_update() {
        Task updated = new Task.Builder().copy(task).setMemberId(1).build();
        String url = baseUrl + "update";
        ResponseEntity<Task> postResponse = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).postForEntity(url, updated, Task.class);
        assertEquals(task.getTaskId(), postResponse.getBody().getTaskId());
    }

    @Test
    public void d_getAll() {
        String url = "/all";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + task.getTaskId();
        restTemplate.withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD).delete(url);
    }
}