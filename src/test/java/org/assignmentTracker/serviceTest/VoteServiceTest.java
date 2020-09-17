package org.assignmentTracker.serviceTest;

import junit.framework.TestCase;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.service.vote.impl.VoteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VoteServiceTest extends TestCase {

    private static VoteService service = VoteService.getService();
    private static Vote vote = VoteFactory.createVote(
            UserFactory.createUser("John", "Doe", "joh#pass1", "john@email.com")
    );

    public void test_d_GetAll() {
        Set<Vote> votes = service.getAll();
        assertTrue(votes.size() > 0);
        System.out.println("Get all: " + service.getAll());
    }

    public void test_a_Create() {
        Vote voteCreated = service.create(vote);
        Assert.assertEquals(voteCreated.getId(), vote.getId());
        System.out.println("Created: " + voteCreated);
    }

    public void test_b_Read() {
        Vote voteRead = service.read(vote.getId());
        System.out.println("Read: " + voteRead);
    }

    public void test_c_Update() {
        User user = UserFactory.createUser("Karen", "Lee", "joh#pass1", "john@email.com");
        Vote voteUpdate = new Vote.Builder().copy(vote).setVoter(user).build();
        voteUpdate = service.update(voteUpdate);

        System.out.println("Updated: " + voteUpdate);
    }

    public void test_e_Delete() {
        boolean isVoteDeleted = service.delete(vote.getId());
        Assert.assertTrue(isVoteDeleted);
    }
}