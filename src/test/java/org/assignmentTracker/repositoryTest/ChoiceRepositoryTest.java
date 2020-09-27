package org.assignmentTracker.repositoryTest;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.repository.choice.impl.ChoiceRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChoiceRepositoryTest {

    private static ChoiceRepository repository = ChoiceRepository.getRepository();
    Vote vote = VoteFactory.createVote(UserFactory.createUser("Sino", "Foji", "pass@123", "sino.foji@protonmail.com"));
    static List<Vote> voteList = new ArrayList<>();
    private static Choice choice = ChoiceFactory.createChoice("APD3", voteList);

    @Test
    public void a_create() {
        voteList.add(vote);
        Choice choice1 = repository.create(choice);
        assertEquals(choice.getId(), choice1.getId());
        System.out.println("Create: " +  choice1);
    }

    @Test
    public void b_read() {
        Choice read = repository.read(choice.getId());
        assertEquals(choice.getId(), read.getId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Choice updated = new Choice.Builder().copy(choice).setName("ICE362s")
                .setVotes(voteList)
                .build();
        updated = repository.update(updated);
        assertNotEquals(choice.getName(), updated.getName());
        System.out.println("Update:" + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(choice.getId());
    }

    @Test
    public void d_getAll() {
        Set<Choice> repo = repository.getAll();
        assertEquals(1,repo.size());
        System.out.println("Get all: " + repo.toString());
    }
}