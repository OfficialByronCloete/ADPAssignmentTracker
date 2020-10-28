package org.assignmentTracker.service.poll.impl;

import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.repository.poll.PollRepository;
//import org.assignmentTracker.repository.poll.impl.PollRepositoryImpl;
import org.assignmentTracker.service.poll.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Implementation class of PollSercvice
 * Date: 06 September 2020
 */
@Service
public class PollServiceImpl implements PollService {

    @Autowired
    private PollRepository repository ;


    @Override
    public Set<Poll> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Poll create(Poll poll) {

        return this.repository.save(poll);
    }

    @Override
    public Poll read(Integer integer) {
        return this.repository.findById(integer).orElseGet(null);
    }

    @Override
    public Poll update(Poll poll) {
        return this.repository.save(poll);
    }

    @Override
    public boolean delete(Integer integer) {

        this.repository.deleteById(integer);
        if(this.repository.existsById(integer)) return false;
        else return true;
    }
}
