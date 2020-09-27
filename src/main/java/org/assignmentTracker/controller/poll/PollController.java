package org.assignmentTracker.controller.poll;


import org.assignmentTracker.entity.Group;
import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.factory.PollFactory;
import org.assignmentTracker.service.poll.impl.PollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Poll controller
 * Date: 27 September 2020
 */

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    private PollServiceImpl pollService;

    @PostMapping("/create")
    public Poll create(@RequestBody Poll poll){

        Poll newPoll = PollFactory.createPoll(poll.getChoices(),
                poll.getCreatedBy(),
                poll.getVoters(),
                poll.getVotes());

        return pollService.create(newPoll);
    }

    public Set<Poll> getAll(){

        return pollService.getAll();
    }

    @GetMapping("/read/{integer}")
    public Poll read(@PathVariable Integer integer){
        return pollService.read(integer);
    }

    @PostMapping("/update")
    public Poll update(@RequestBody Poll poll){

        return pollService.update(poll);
    }

    @DeleteMapping("/delete/{integer}")
    public boolean delete(@PathVariable Integer integer){

        return pollService.delete(integer);

    }

}
