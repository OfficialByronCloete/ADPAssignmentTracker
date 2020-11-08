/*package org.assignmentTracker.repository.task.impl;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.repository.task.ITaskRepository;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Caleb Ruiters
 * student number: 215169751
 * Desc: Repository/Data Access Layer of the Task entity
 * Date: 27 August 2020


public class TaskRepositoryImpl implements ITaskRepository {

    private static TaskRepositoryImpl repository = null;
    private Set<Task> taskDB;

    private TaskRepositoryImpl() {this.taskDB = new HashSet<>();}

    public static TaskRepositoryImpl getRepository() {
        if (repository == null) repository = new TaskRepositoryImpl();
            return repository;
    }

    @Override
    public Set<Task> getAll() {
        return taskDB;
    }

    @Override
    public Task create(Task task) {
        this.taskDB.add(task);
        return task;
    }

    @Override
    public Task read(Integer integer) {
        for (Task task: taskDB) {
            if (task.equals(integer));
            return task;
        }
        return null;
    }

    @Override
    public Task update(Task task) {
        boolean deleteTask = delete(task.getTaskId());
        if (deleteTask){
            this.taskDB.remove(task);
            return task;
        }
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        Task task = read(integer);
        if (task != null){
            this.taskDB.remove(task);
            return true;
        }
        return false;
    }
}*/
