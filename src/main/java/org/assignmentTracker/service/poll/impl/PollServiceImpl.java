package org.assignmentTracker.service.poll.impl;

import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.repository.poll.PollRepository;
import org.assignmentTracker.repository.poll.impl.PollRepositoryImpl;
import org.assignmentTracker.service.poll.PollService;

import java.util.Set;
/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Implementation class of PollSercvice
 * Date: 06 September 2020
 */
public class PollServiceImpl implements PollService {


    private static PollService service = null;
    private PollRepository repository ;

    private PollServiceImpl() {

        this.repository = PollRepositoryImpl.getRepository();
    }

    public static PollService getService (){

        if(service == null)
            service = new PollServiceImpl();

            return service;
    }


    @Override
    public Set<Poll> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Poll create(Poll poll) {

        return this.repository.create(poll);
    }

    @Override
    public Poll read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public Poll update(Poll poll) {
        return this.repository.update(poll);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }
}
