package org.assignmentTracker.repositoryTest;

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.factory.LectureFactory;
import org.assignmentTracker.repository.lecture.LectureRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: class that test lecture repository impl
 * Date: 28 August 2020
 */
/*@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureRepositoryImplTest {


    private static LectureRepository repository = LectureRepositoryImpl.getRepository();

    private static Lecture newLecture = LectureFactory.newLecture("Justin","Kokolo","justin@","4947","2");



    @Test
    public void getRepository() {
    }


    @Test
    public void a_create() {

        Lecture lecture = repository.create(newLecture);
        Assert.assertEquals(lecture.getId(), lecture.getId());
        System.out.println("Created: " + lecture);
    }

    @Test
    public void b_read() {

        Lecture read = repository.read(newLecture.getId());
        System.out.println("Created: " + read);
    }

    @Test
    public void c_update() {

        Lecture updateLecture = LectureFactory.newLecture("Ronald", "Mua", "jo.@mail", "0764289","5");
        Lecture update = new Lecture.Builder().copy(updateLecture).setEmail("justinko@gmail.com").build();
        update = repository.update(update);

        System.out.println("Updated: " + update);
    }

    @Test
    public void e_delete() {

        boolean deleted = repository.delete(newLecture.getId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }
}*/