package org.assignmentTracker.serviceTest;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.service.user.IUserService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    private static IUserService service;
    private static User user = UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com");

    @Test
    public void a_create() {
        User created = service.create(user);
        Assert.assertEquals(user.getID(), created.getID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        User read = service.read(user.getID());
        System.out.println("Created: " + read);
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).setPassword("mynewpassword").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_getAllSurnamesThatStartWithC() {

        System.out.println("Names that start with C:" + service.getAllSurnamesThatStartWithC());
    }

    @Test
    public void f_getAll() {
        System.out.println("Get all: " + service.getAll());
    }

    @Test
    public void g_delete() {
        boolean deleted = service.delete(user.getID());
        Assert.assertTrue(deleted);
    }
}