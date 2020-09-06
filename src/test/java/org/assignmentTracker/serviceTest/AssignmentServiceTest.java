package org.assignmentTracker.serviceTest;

import junit.framework.TestCase;
import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.AssignmentFactory;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.service.assignment.impl.AssignmentService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentServiceTest extends TestCase {

    private static AssignmentService service = AssignmentService.getService();
    private static Assignment assignment = AssignmentFactory.createAssignment(
            "ADP376S Assignment 7",
            SubjectFactory.createSubject("Application Development", "ADP376S", "Arinze Anikwe", new Date(4556)),
            new Date(45569),
            null,
            null,
            UserFactory.createUser("John", "Doe", "joh#pass1", "john@email.com")
    );

    public void d_testGetAll() {
        Set<Assignment> assignments = service.getAll();
        assertTrue(assignments.size() > 0);
        System.out.println("Get all: " + service.getAll());
    }

    public void a_testCreate() {
        Assignment assignmentCreated = service.create(assignment);
        Assert.assertEquals(assignmentCreated.getId(), assignment.getId());
        System.out.println("Created: " + assignmentCreated);
    }

    public void b_testRead() {
        Assignment assignmentRead = service.read(assignment.getId());
        System.out.println("Read: " + assignmentRead);
    }

    public void c_testUpdate() {
        User user = UserFactory.createUser("Karen", "Lee", "joh#pass1", "john@email.com");
        Assignment assignmentUpdate = new Assignment.Builder().copy(assignment).setName("Assignment 5 Repository Pattern").build();
        assignmentUpdate = service.update(assignmentUpdate);

        System.out.println("Updated: " + assignmentUpdate);
    }

    public void e_testDelete() {
        boolean isAssignmentDeleted = service.delete(assignment.getId());
        Assert.assertTrue(isAssignmentDeleted);
    }
}