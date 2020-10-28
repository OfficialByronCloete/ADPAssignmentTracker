package org.assignmentTracker.serviceTest;

import static org.junit.Assert.*;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: test class of lecture service
 * Date: 05 September 2020
 */

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.factory.LectureFactory;
import org.assignmentTracker.service.lecture.ILectureService;
import org.assignmentTracker.service.lecture.impl.LectureServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureServiceImplTest {


    private static ILectureService service = LectureServiceImpl.getService();
    private static Lecture lecture = LectureFactory.newLecture("Justin","Kokolo","justu@","9488","5");
    private static Lecture lecture1 = LectureFactory.newLecture("Loreil","Kabs","justu@","9488","5");
    private static Lecture lecture2 = LectureFactory.newLecture("Louis","Roland","justu@","9488","5");



    @Test
    public void a_create() {

        Lecture created_1 = service.create(lecture);
        Lecture created_2 = service.create(lecture1);
        Lecture created_3 = service.create(lecture2);
        Assert.assertEquals(lecture.getId(), created_1.getId());
        Assert.assertEquals(lecture1.getId(), created_2.getId());
        Assert.assertEquals(lecture2.getId(), created_3.getId());
        System.out.println(("Created: " + created_1 + "\n" + created_2 + "\n" + created_3));

    }

    @Test
    public void b_read() {
        Lecture read = service.read(lecture.getId());
        System.out.println("Created: " + read);
    }

    @Test
    public void c_update() {
        Lecture updated = new Lecture.Builder().copy(lecture).setCell_num("New phone number").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }



    @Test
    public void d_getAll() {
        System.out.println("Get all: " + service.getAll());
    }

    @Test
    public void e_getAllNamesThatStartWithK() {

        System.out.println("Names that start with k:" + service.getAllNamesThatStartWithK());
    }


    @Test
    public void f_delete() {

        boolean deleted = service.delete(lecture.getId());
        Assert.assertTrue(deleted);
    }
}