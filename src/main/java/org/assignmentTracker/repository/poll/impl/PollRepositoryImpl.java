package org.assignmentTracker.repository.poll.impl;

import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.repository.poll.PollRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc:
 * Date: 30 August 2020
 */

public class PollRepositoryImpl implements PollRepository {

    private static PollRepository repository = null;
    private Set <Poll> pollDB;

    private PollRepositoryImpl () {this.pollDB = new HashSet<>();
    }

    public static PollRepository getRepository() {

        if (repository == null)
            repository = new PollRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Poll> getAll() {

        return this.pollDB;
    }

    @Override
    public Poll create(Poll poll) {
        this.pollDB.add(poll);
        return poll;
    }

    @Override
    public Poll read(Integer id) {

        for(Poll poll : this.pollDB){
            if(poll.getId() == id )
                return poll;
        }

        return null;
    }

    @Override
    public Poll update(Poll poll) {

        boolean deletePoll = delete(poll.getId());

        if (deletePoll) {
            this.pollDB.add(poll);
            return poll;
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Poll poll = read(id);

        if(poll != null){
            this.pollDB.remove(poll);
            return true;
        }

        return false;
    }

}

