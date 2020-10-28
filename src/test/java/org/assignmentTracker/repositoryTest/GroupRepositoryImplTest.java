package org.assignmentTracker.repositoryTest;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.factory.GroupFactory;
import org.assignmentTracker.repository.group.GroupRepository;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: group repository test class
 * Date: 30 August 2020
 */
/*
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class GroupRepositoryImplTest {

    @Autowired
    private static GroupRepository repository ;
    private static Group group = GroupFactory.createGroup("Group 13",
            "Arinze Anikwue","Application Development Practice");

    @Test
    public void d_getAll() {

        System.out.println("Get all: "+ repository.getAll());
    }

    @Test
    public void a_create() {

        Group created = repository.save(group);
        Assert.assertEquals(group.getId() , created.getId());
        System.out.println("Created: "+ created);
    }

    @Test
    public void b_read() {
        Group read = repository.read(group.getId());
        System.out.println("Read: "+ read);
    }

    @Test
    public void c_update() {

        Group update = new Group.Builder().copy(group).setName("Group thirteen").build();
        update = repository.save(update);
        System.out.println("Update: "+ update);

    }

    @Test
    public void e_delete() {

        boolean deleted = repository.delete(group.getId());
        Assert.assertTrue(deleted);
    }
}
*/
