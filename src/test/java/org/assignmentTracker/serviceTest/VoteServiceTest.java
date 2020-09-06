package org.assignmentTracker.serviceTest;

import junit.framework.TestCase;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.repository.vote.impl.VoteRepository;
import org.assignmentTracker.service.vote.impl.VoteService;
import org.junit.Assert;

import java.util.Set;

public class VoteServiceTest extends TestCase {

    private static VoteService service = VoteService.getService();
    private static Vote vote = VoteFactory.createVote(
            UserFactory.createUser("John", "Doe", "joh#pass1", "john@email.com")
    );

    public void d_testGetAll() {
        Set<Vote> votes = service.getAll();
        assertTrue(votes.size() > 0);
        System.out.println("Get all: " + service.getAll());
    }

    public void a_testCreate() {
        Vote voteCreated = service.create(vote);
        Assert.assertEquals(voteCreated.getId(), vote.getId());
        System.out.println("Created: " + voteCreated);
    }

    public void b_testRead() {
        Vote voteRead = service.read(vote.getId());
        System.out.println("Read: " + voteRead);
    }

    public void c_testUpdate() {
        User user = UserFactory.createUser("Karen", "Lee", "joh#pass1", "john@email.com");
        Vote voteUpdate = new Vote.Builder().copy(vote).setVoter(user).build();
        voteUpdate = service.update(voteUpdate);

        System.out.println("Updated: " + voteUpdate);
    }

    public void e_testDelete() {
        boolean isVoteDeleted = service.delete(vote.getId());
        Assert.assertTrue(isVoteDeleted);
    }
}