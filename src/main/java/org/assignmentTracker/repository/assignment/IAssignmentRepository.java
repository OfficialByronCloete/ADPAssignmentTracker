package org.assignmentTracker.repository.assignment;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: repository/impl/VoteRepository data access layer
 * Date: 25 August 2020
 */
public interface IAssignmentRepository extends JpaRepository<Assignment, Integer> {
}
