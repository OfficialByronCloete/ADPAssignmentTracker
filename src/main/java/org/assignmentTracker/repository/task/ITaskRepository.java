package org.assignmentTracker.repository.task;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *
 * @author: Caleb Ruiters
 * student number: 215169751
 * */

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

}
