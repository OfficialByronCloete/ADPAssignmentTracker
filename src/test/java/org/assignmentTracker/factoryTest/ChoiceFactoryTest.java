package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.repository.vote.impl.VoteRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ChoiceFactoryTest {

    @Test
    public void choiceFactory() {
        Vote votes = VoteFactory.createVote(UserFactory.createUser("Lutho", "Pama", "pass@123","lpama@email.com"));
        List<Vote> voteList = new ArrayList<>();
        voteList.add(votes);
        Choice choiceName = ChoiceFactory.createChoice("Anganathi", voteList);
        System.out.println(choiceName.toString());
        Assert.assertEquals("Anganathi", choiceName.getName());
    }

}