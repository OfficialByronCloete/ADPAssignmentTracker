package org.assignmentTracker.controller.user;


import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.service.user.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/*
@author Byron Cloete
StudNo: 214189872
Date: 26 September 2020
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        User newUser = UserFactory.createUser(
                user.getName(),
                user.getSurname(),
                user.getPassword(),
                user.getEmail());

        return userService.create(newUser);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable int id){
        return userService.read(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @GetMapping("/all")
    public Set<User> getAll(){
        return userService.getAll();
    }

}
