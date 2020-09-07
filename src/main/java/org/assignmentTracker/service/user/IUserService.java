package org.assignmentTracker.service.user;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IUserService extends IService<User, Integer> {
    Set<User> getAll();
    Set<User> getAllSurnamesThatStartWithC();
}
