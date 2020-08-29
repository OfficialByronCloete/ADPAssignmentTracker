package org.assignmentTracker.factory;


import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.entity.Member;
import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.util.Helper;

import java.util.List;

/**
 * @author : Sinovuyo May
 * Student no: 217298915
 * Date : 05 July 2020
 * Desc: Poll factory entity
 */

public class PollFactory {





    public static Poll createPoll(List<Choice> choices, User createdBy, Member voters, String votes){

        int pollID = Helper.generateID();
        Poll poll = new Poll.Builder()
                .setId(pollID)
                .setChoices(choices)
                .setCreatedBy(createdBy)
                .setVoters(voters)
                .setVotes(votes)
                .build();

        return poll;
    }

}


