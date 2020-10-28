//package org.assignmentTracker.repositoryTest;
//
///**
// * @author : Lyse-Celeste Irakoze
// * Student Number : 217132057
// * Date : 30 August 2020
// * Test class for SubjectRepositoryImpl
// */
//
//import org.assignmentTracker.entity.Subject;
//import org.assignmentTracker.factory.SubjectFactory;
//import org.assignmentTracker.repository.subject.impl.SubjectRepositoryImpl;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Date;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class SubjectRepositoryImplTest {
//
//    private static SubjectRepositoryImpl repository = SubjectRepositoryImpl.getRepository();
//    private static Subject subject = SubjectFactory.createSubject("Applications Development Practice", "ADP(362S)", "DDD Chapter 1", new Date());
//
//    @Test
//    public void a_create() {
//        Subject created = repository.create(subject);
//        Assert.assertEquals(created.getId(), subject.getId());
//        System.out.println(created + " : created");
//    }
//
//    @Test
//    public void b_read() {
//
//        Subject read = repository.read(subject.getId());
//        System.out.println(read + " : Read ");
//    }
//
//    @Test
//    public void c_update() {
//
//        Subject updated = new Subject.Builder().copy(subject).setName("ADP_CORE_01").build();
//        updated = repository.update(updated);
//        System.out.println(updated + " : updated");
//    }
//
//    @Test
//    public void d_getAll() {
//        System.out.println(repository.getAll() + " : Is everything");
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(subject.getId());
//        Assert.assertTrue(deleted);
//    }
//}
