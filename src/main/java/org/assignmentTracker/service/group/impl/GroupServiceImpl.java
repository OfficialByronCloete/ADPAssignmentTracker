package org.assignmentTracker.service.group.impl;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.repository.group.GroupRepository;
import org.assignmentTracker.repository.group.impl.GroupRepositoryImpl;
import org.assignmentTracker.service.group.GroupService;
import org.springframework.stereotype.Service;


import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Implementation class of GroupService
 * Date: 06 September 2020
 */

@Service
public class GroupServiceImpl implements GroupService  {

    private static GroupService service = null;
    private GroupRepository repository ;

    private GroupServiceImpl() {
        this.repository = GroupRepositoryImpl.getRepository();
    }

    public static GroupService getService (){

        if(service == null)
            service = new GroupServiceImpl();

        return service;
    }


    @Override
    public Set<Group> getAll() {

        return this.repository.getAll();
    }


    @Override
    public Group create(Group group) {

        return this.repository.create(group) ;
    }

    @Override
    public Group read(Integer integer) {

        return this.repository.read(integer);
    }

    @Override
    public Group update(Group group) {

        return this.repository.update(group);
    }

    @Override
    public boolean delete(Integer integer) {

        return this.repository.delete(integer);
    }
}
