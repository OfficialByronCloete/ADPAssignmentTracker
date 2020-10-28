package org.assignmentTracker.service.task.impl;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.repository.task.impl.TaskRepositoryImpl;
import org.assignmentTracker.service.task.TaskService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    private static TaskServiceImpl service = null;
    private TaskRepositoryImpl repository;

    private TaskServiceImpl() { this.repository = TaskRepositoryImpl.getRepository(); }

    public static TaskServiceImpl getService() {
        if (service == null) service = new TaskServiceImpl();
        return service;
    }

    @Override
    public Set<Task> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Task> getTaskNumber() {
        Set<Task> tasks = getAll();
        Set<Task> taskNumber = new HashSet<>();
        for (Task task: tasks) {
            if (task.getTaskId() == 2)
                taskNumber.add(task);
        }
        return taskNumber;
    }

    @Override
    public Task create(Task task) {
        return this.repository.create(task);
    }

    @Override
    public Task read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public Task update(Task task) {
        return this.repository.update(task);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }
}
