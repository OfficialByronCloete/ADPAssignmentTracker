package org.assignmentTracker.repository.task;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

/**
 *
 * @author: Caleb Ruiters
 * student number: 215169751
 * */
public interface ITaskRepository extends IRepository<Task, Integer> {
    Set<Task> getAll();
}
