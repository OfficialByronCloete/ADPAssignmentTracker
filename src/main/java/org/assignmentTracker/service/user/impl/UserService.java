package org.assignmentTracker.service.user.impl;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.repository.user.impl.UserRepository;
import org.assignmentTracker.service.user.IUserService;

import java.util.HashSet;
import java.util.Set;

public class UserService implements IUserService {

    private static IUserService service = null;
    private UserRepository repo;

    private UserService(){
        this.repo = UserRepository.getRepo();
    }

    public static IUserService getService(){
        if(service == null) service = new UserService();
        return service;
    }

    @Override
    public Set<User> getAll() {
        return this.repo.getAll();
    }

    @Override
    public Set<User> getAllSurnamesThatStartWithC() {
        Set<User> users = getAll();
        Set<User> usersWithC = new HashSet<>();
        for(User user : users){
            if(user.getSurname().trim().toLowerCase().startsWith("c")){
                usersWithC.add(user);
            }
        }
        return usersWithC;
    }

    @Override
    public User create(User user) {
        return this.repo.create(user);
    }

    @Override
    public User read(Integer integer) {
        return this.repo.read(integer);
    }

    @Override
    public User update(User user) {
        return this.repo.update(user);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repo.delete(integer);
    }
}
