//package org.assignmentTracker.repositoryTest;
//
//import junit.framework.TestCase;
//import org.assignmentTracker.entity.Assignment;
//import org.assignmentTracker.entity.User;
//import org.assignmentTracker.factory.AssignmentFactory;
//import org.assignmentTracker.factory.SubjectFactory;
//import org.assignmentTracker.factory.UserFactory;
//import org.assignmentTracker.repository.assignment.IAssignmentRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AssignmentRepositoryTest extends TestCase {
//
//    private static Assignment assignment = AssignmentFactory.createAssignment(
//            "ADP376S Assignment 7",
//            SubjectFactory.createSubject("Application Development", "ADP376S", "Arinze Anikwe", new Date(4556)),
//            new Date(45569),
//            null,
//            null,
//            UserFactory.createUser("John", "Doe", "joh#pass1", "john@email.com")
//    );
//    @Autowired
//    private IAssignmentRepository repository;
//
//    @Test
//    public void test_a_create() {
//        Assignment assignmentCreated = repository.save(assignment);
//        Assert.assertEquals(assignmentCreated.getId(), assignment.getId());
//        System.out.println("Created: " + assignmentCreated);
//    }
//
//    @Test
//    public void test_b_read() {
//        Assignment assignmentRead = repository.findById(assignment.getId()).orElse(null);
//        System.out.println("Read: " + assignmentRead);
//    }
//
//    @Test
//    public void test_c_update() {
//        User user = UserFactory.createUser("Karen", "Lee", "joh#pass1", "john@email.com");
//        Assignment assignmentUpdate = new Assignment.Builder().copy(assignment).setName("Assignment 5 Repository Pattern").build();
//        assignmentUpdate = repository.save(assignmentUpdate);
//
//        System.out.println("Updated: " + assignmentUpdate);
//    }
//
//    @Test
//    public void test_d_getAll() {
//        System.out.println("Get all: " + repository.findAll());
//    }
//
//    @Test
//    public void test_e_Delete() {
//        boolean isAssignmentDeleted = repository.deleteById(assignment.getId());
//        Assert.assertTrue(isAssignmentDeleted);
//    }
//}
