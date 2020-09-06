package org.assignmentTracker.service.assignment;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IAssignmentService extends IService<Assignment, Integer> {
    Set<Assignment> getAll();
}