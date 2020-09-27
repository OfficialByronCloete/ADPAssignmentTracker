package org.assignmentTracker.service.assignment.impl;

import org.assignmentTracker.entity.Assignment;
import org.assignmentTracker.repository.assignment.impl.AssignmentRepository;
import org.assignmentTracker.service.assignment.IAssignmentService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * AssignmentService.java
 * Assignment service implementation
 * Date: 06 August 2020
 * @author Claude Christ De-Tchambila
 * student number: 217035027
 */
@Service
public class AssignmentService implements IAssignmentService {

    private static AssignmentService service = null;
    private AssignmentRepository repository;

    public AssignmentService() {
        this.repository = AssignmentRepository.getRepository();
    }

    public static AssignmentService getService() {
        if (service == null) service = new AssignmentService();
        return service;
    }

    @Override
    public Set<Assignment> getAll() {
        return repository.getAll();
    }

    @Override
    public Assignment create(Assignment assignment) {
        return repository.create(assignment);
    }

    @Override
    public Assignment read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return repository.update(assignment);
    }

    @Override
    public boolean delete(Integer integer) {
        return repository.delete(integer);
    }

}