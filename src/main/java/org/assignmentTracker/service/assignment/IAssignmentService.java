package org.assignmentTracker.service.user;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IAssignmentService extends IService<Assigment, Integer> {
    Set<Assignment> getAll();
    Set<User> getAllSurnamesThatStartWithC();
}