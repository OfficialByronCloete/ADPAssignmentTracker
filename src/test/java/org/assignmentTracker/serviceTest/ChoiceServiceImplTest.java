package org.assignmentTracker.serviceTest;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.service.choice.impl.ChoiceServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChoiceServiceImplTest {
    @Autowired
    private static ChoiceServiceImpl choiceService ;
    static List<Vote> voteList = new ArrayList<>();
    private static Choice choice = ChoiceFactory.createChoice("Java", voteList);

    @Test
    public void d_getAll() {
        Set<Choice> choices = choiceService.getAll();
        assertEquals(1, choices.size());
        System.out.println("All: " + choices);
    }

    @Test
    public void a_create() {
        Choice created = choiceService.create(choice);
        assertEquals(choice.getId(), created.getId());
        System.out.println("Create: " + created);
    }

    @Test
    public void b_read() {
        Choice read = choiceService.read(choice.getId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Choice updated = new Choice.Builder().copy(choice).setName("Python").build();
         updated = choiceService.update(updated);
        System.out.println("Update :" + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = choiceService.delete(choice.getId());
        assertTrue(deleted);
    }
}