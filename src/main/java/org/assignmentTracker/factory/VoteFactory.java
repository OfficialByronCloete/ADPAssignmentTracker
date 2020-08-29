package org.assignmentTracker.factory;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.util.Helper;


/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: Factory/Vote provides an abstraction layer for creating Vote objects
 * Date: 5 July 2020
 */
public class VoteFactory {

    public static Vote createVote(User user) {
        int id = Helper.generateVoteId();

        Vote vote = new Vote.Builder()
                .setId(id)
                .setVoter(user)
                .build();

        return vote;
    }

}
