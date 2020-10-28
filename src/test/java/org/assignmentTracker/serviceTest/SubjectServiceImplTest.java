package org.assignmentTracker.serviceTest;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * Test class for SubjectServiceImpl
 */

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.service.subject.ISubjectService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectServiceImplTest {

    @Autowired
    //    private ISubjectService service;
    private ISubjectService service;
    private static Subject subject = SubjectFactory.createSubject("Applications Development Practice", "adp372s", "assignments SDLC", new Date());
    private static Subject subject1 = SubjectFactory.createSubject("Applications Development Theory", "adt372s", "Chapter 4 SDLC", new Date());
    private static Subject subject2 = SubjectFactory.createSubject("Elective", "ICE372s", "chapter 3 angular Frameworks",  new Date());


    @Test
    public void A_create() {

        Subject created = service.create(subject);
        Subject created1 = service.create(subject1);
        Subject created2 = service.create(subject2);

        Assert.assertEquals(subject.getId(),created.getId());
        Assert.assertEquals(subject1.getId(),created1.getId());
        Assert.assertEquals(subject2.getId(),created2.getId());

        System.out.println( created+ "\n" + created1 + "\n" + created2 + "\n created \n");
    }

    @Test
    public void b_read() {
        Subject read = service.read(subject.getId());
        System.out.println( read + "\n read \n" );
    }

    @Test
    public void c_update() {
        Subject updated = new Subject.Builder().copy(subject).setName("Electives").build();
        updated = service.update(updated);
        System.out.println(  updated + "\n Updated \n" );
    }

    @Test
    public void e_getAllLectureThatStartWithA() {

        System.out.println("\n Lectures that starts with A : \n" + service.getAllLectureThatStartWithA());
    }

    @Test
    public void f_getAll() {
        System.out.println( "\n" + service.getAll() + "\n This is Everything \n" );
    }

    @Test
    public void g_delete() {
        boolean deleted = service.delete(subject.getId());
        Assert.assertTrue(deleted);
    }
}