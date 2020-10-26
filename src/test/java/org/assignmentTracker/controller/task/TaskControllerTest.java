package org.assignmentTracker.controller.task;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.entity.Task;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TaskControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static Task task;
    private final String baseUrl = "http://localhost:8080/assignment";

    @Test
    public void a_create() {
    }

    @Test
    public void b_read() {
    }

    @Test
    public void c_update() {
    }

    @Test
    public void d_getAll() {
    }

    @Test
    public void e_delete() {
    }
}