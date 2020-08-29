package org.assignmentTracker.factoryTest;

import org.junit.Test;

import static org.junit.Assert.*;
import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.ChoiceFactory;
import org.assignmentTracker.factory.PollFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.assignmentTracker.factory.UserFactory.createUser;
import static org.junit.Assert.*;
/**
 * @author : Sinovuyo May
 * Student no: 217298915
 * Date : 05 July 2020
 *Desc: createPoll method test class
 */


public class PollFactoryTest {

    @Test
    public void createPoll() {

        User user = createUser("Sinovuyo","May","******","Sinovuyofoji28@gmail.com");
        //did not create choice and member because they both require a list in their entities
        Poll poll = new PollFactory().createPoll(null,user,null,"Yes/No");

        Assert.assertEquals(poll.getVotes(),null);

    }
}