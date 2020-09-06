package org.assignmentTracker.serviceTest;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.repository.user.impl.UserRepository;
import org.assignmentTracker.service.user.IUserService;
import org.assignmentTracker.service.user.impl.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    private static IUserService service = UserService.getService();
    private static User user = UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com");
    private static User user2 = UserFactory.createUser("Adrian", "Brody", "spatula", "adrianbrody@gmail.com");
    private static User user3 = UserFactory.createUser("Cassidy", "Coetzee", "bookworm", "casscoetzee@gmail.com");


    @Test
    public void a_create() {
        User created = service.create(user);
        User created2 = service.create(user2);
        User created3 = service.create(user3);
        Assert.assertEquals(user.getID(), created.getID());
        Assert.assertEquals(user2.getID(), created2.getID());
        Assert.assertEquals(user3.getID(), created3.getID());
        System.out.println(("Created: " + created + "\n" + created2 + "\n" + created3));
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