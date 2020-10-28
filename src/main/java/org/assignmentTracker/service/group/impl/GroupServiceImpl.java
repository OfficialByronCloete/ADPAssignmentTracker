package org.assignmentTracker.service.group.impl;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.repository.group.GroupRepository;
//import org.assignmentTracker.repository.group.impl.GroupRepositoryImpl;
import org.assignmentTracker.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Implementation class of GroupService
 * Date: 06 September 2020
 */

@Service
public class GroupServiceImpl implements GroupService  {

    @Autowired
    private GroupRepository repository ;

    @Override
    public Set<Group> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Group create(Group group) {

        return this.repository.save(group) ;
    }

    @Override
    public Group read(Integer integer) {

        return this.repository.findById(integer).orElseGet(null);
    }

    @Override
    public Group update(Group group) {



        return this.repository.save(group);
    }

    @Override
    public boolean delete(Integer integer) {

         this.repository.deleteById(integer);
         if(this.repository.existsById(integer)) return false;
         else return true;
    }
}
