package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class VoteFactoryTest {


    @Test
    public void createVote() {
        User user = UserFactory.createUser("William", "King", "passWill123", "williamK@cput.ac.za");

        Vote vote = VoteFactory.createVote(user);

        Assert.assertEquals(vote.getVoter(), user);
    }
}