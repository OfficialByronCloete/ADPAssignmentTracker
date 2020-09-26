package org.assignmentTracker.service.vote.impl;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.repository.vote.impl.VoteRepository;
import org.assignmentTracker.service.vote.IVoteService;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * VoteService.java
 * Vote service implementation
 * Date: 06 August 2020
 * @author Claude Christ De-Tchambila
 * student number: 217035027
 */
@Service
public class VoteService implements IVoteService {

    private static VoteService service = null;
    private VoteRepository repository;

    public VoteService() {
        this.repository = VoteRepository.getRepository();
    }

    public static VoteService getService() {
        if (service == null) service = new VoteService();
        return service;
    }

    @Override
    public Set<Vote> getAll() {
        return repository.getAll();
    }

    @Override
    public Vote create(Vote vote) {
        return repository.create(vote);
    }

    @Override
    public Vote read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Vote update(Vote vote) {
        return repository.update(vote);
    }

    @Override
    public boolean delete(Integer integer) {
        return repository.delete(integer);
    }
}


