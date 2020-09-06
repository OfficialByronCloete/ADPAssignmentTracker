package org.assignmentTracker.service.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IVoteService extends IService<Vote, Integer> {
    Set<Vote> getAll();
}