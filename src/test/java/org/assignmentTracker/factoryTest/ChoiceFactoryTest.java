package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.ChoiceFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ChoiceFactoryTest {

    @Test
    public void choiceFactory() {
        List<Vote> voteList = new ArrayList<>();
        Choice choiceName = ChoiceFactory.createChoice("Anganathi", voteList);
        System.out.println(choiceName.getId());
        Assert.assertEquals("Anganathi", choiceName.getName());
    }
}