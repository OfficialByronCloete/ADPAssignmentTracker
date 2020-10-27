package org.assignmentTracker.service.user.impl;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.repository.user.IUserRepository;
import org.assignmentTracker.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private static IUserService service = null;
    @Autowired
    private IUserRepository repo;

    @Override
    public Set<User> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
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
    public User create(User user) { return this.repo.save(user); }

    @Override
    public User read(Integer integer) {
        return this.repo.findById(integer).orElseGet(null);
    }

    @Override
    public User update(User user) {
        return this.repo.save(user);
    }

    @Override
    public boolean delete(Integer integer) {
        this.repo.deleteById(integer);
        if(this.repo.existsById(integer)) return false;
        else return true;
    }
}
