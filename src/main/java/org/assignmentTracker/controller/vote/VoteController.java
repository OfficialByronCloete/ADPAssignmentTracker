package org.assignmentTracker.controller.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.factory.VoteFactory;
import org.assignmentTracker.service.vote.impl.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/create")
    public Vote create(@RequestBody Vote vote) {
        Vote newVote = VoteFactory.createVote(vote.getVoter());

        return voteService.create(newVote);
    }

    @GetMapping("/all")
    public Set<Vote> getAll() {
        return voteService.getAll();
    }

}
