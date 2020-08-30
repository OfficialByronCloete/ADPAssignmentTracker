package org.assignmentTracker.repositoryTest;

import junit.framework.TestCase;
import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.AdminFactory;
import org.assignmentTracker.factory.AssignmentFactory;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.repository.admin.impl.AdminRepositoryImpl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

import static org.assignmentTracker.factory.UserFactory.createUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryTest extends TestCase {

    private static AdminRepositoryImpl repository = AdminRepositoryImpl.getRepo();
    private static User user1 = createUser("Brandon", "Villet", "pass", "villetbrandon@gmail.com");//create user to insert into admin
    private static Admin admin = AdminFactory.createAdmin(user1, null);
    @Test
    public void test_a_create() {
        Admin adminCreated = repository.create(admin);
        Assert.assertEquals(adminCreated.getId(), admin.getId());
        System.out.println("Created: " + adminCreated);
    }
    @Test
    public void test_b_read() {
        Admin adminRead = repository.read(admin.getId());
        System.out.println("Read: " + adminRead);
    }
    @Test
    public void test_c_update() {
        Assignment assignment = AssignmentFactory.createAssignment(
                "ADP376S Assignment 7",
                SubjectFactory.createSubject("Application Development", "ADP376S", "Arinze Anikwe", new Date(4556)),
                new Date(45569),
                null,
                null,
                null
        );
        Admin updated = new Admin.Builder().copy(admin).setAssignment(assignment).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void test_d_getAll() {
        User user2 = createUser("John", "Doe", "word", "DoeJohn@gmail.com");//create user to insert into admin
        Admin admin2 = AdminFactory.createAdmin(user2, null);
        Admin adminCreated = repository.create(admin2);
        System.out.println("Get all: " + repository.getAll());
    }

    @Test
    public void test_e_Delete() {
        boolean isAdminDeleted = repository.delete(admin.getId());
        Assert.assertTrue(isAdminDeleted);
    }
}
