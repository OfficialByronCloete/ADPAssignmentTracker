package org.assignmentTracker.controller;

import org.assignmentTracker.entity.Note;
import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.factory.NoteFactory;
import org.assignmentTracker.factory.UserFactory;
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

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Test class for NoteController
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class NoteControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/note";
    private static Note note;




    @Test
    public void a_create(){

        Note newNote = NoteFactory.createNote("Chapter 101", "Summary",
                UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com"), new Date());
        String url = baseURL + "/note";
        ResponseEntity<Note> postResponse = restTemplate.postForEntity(url, newNote, Note.class);

        assertNotNull(postResponse.getBody());
        note = postResponse.getBody();

        System.out.println("Create note");
        System.out.println(postResponse.getBody());
    }


    @Test
    public void b_read(){
        int id = note.getId();
        String url = baseURL + "/read/" + id;
        ResponseEntity<Subject> getResponse = restTemplate.getForEntity(url, Subject.class);
        System.out.println(getResponse.getBody());
    }


    @Test
    public void c_update(){

       Note updated = new Note.Builder().copy(note).setText("Chapter 102").build();
        String url = baseURL + "updated";
        System.out.println("URL"+url);
        System.out.println("Post data "+ updated);
        ResponseEntity<Note> response =restTemplate.postForEntity(url,updated, Note.class);
        Assert.assertNotSame(note,note.getId());

    }

    @Test
    public void d_getall(){
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity= new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("All subjects displayed");
        System.out.println(response.getBody());

    }

    public void e_delete(){

        String url = baseURL + "/delete/" + note.getId();
        restTemplate.delete(url);

        ResponseEntity<List> response = restTemplate.getForEntity(baseURL + "/all", List.class);

        System.out.println(response.getBody());
    }



}
