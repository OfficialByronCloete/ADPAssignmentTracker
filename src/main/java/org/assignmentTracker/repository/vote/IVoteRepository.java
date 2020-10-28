package org.assignmentTracker.repository.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: repository/IVoteRepository data access layer
 * Date: 28 October 2020
 */
@Repository
public interface IVoteRepository extends JpaRepository<Vote, Integer> {
}
