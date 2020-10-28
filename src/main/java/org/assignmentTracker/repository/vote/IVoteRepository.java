package org.assignmentTracker.repository.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IVoteRepository extends JpaRepository<Vote, Integer> {
}
