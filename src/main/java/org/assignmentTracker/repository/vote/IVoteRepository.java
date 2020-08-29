package org.assignmentTracker.repository.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

public interface IVoteRepository extends IRepository<Vote, Integer> {

    Set<Vote> getAll();

}
