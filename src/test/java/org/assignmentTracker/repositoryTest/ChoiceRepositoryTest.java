package org.assignmentTracker.repositoryTest;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.repository.choice.impl.ChoiceRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChoiceRepositoryTest {

    private static ChoiceRepository repository = new ChoiceRepository();
    List<Vote> voteList = new ArrayList<>();
    private Choice choice = ChoiceFactory.createChoice("APD3", voteList);

    @Test
    public void a_create() {
        Choice choice1 = repository.create(choice);
        assertEquals(choice.getId(), choice1.getId());
        System.out.println("Create: " +  choice1);
    }

    @Test
    public void b_read() {
        Choice read = repository.read(choice.getId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Choice updated = new Choice.Builder().copy(choice).setName("ICE362s")
                .setVotes(voteList)
                .build();
        updated = repository.update(updated);
        System.out.println("Update:" + updated);
    }

    @Test
    public void delete() {
        repository.delete(choice.getId());
    }

    @Test
    public void e_getAll() {
        repository.getAll();
    }
}