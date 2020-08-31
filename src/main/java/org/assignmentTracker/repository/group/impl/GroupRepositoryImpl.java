package org.assignmentTracker.repository.group.impl;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.repository.group.GroupRepository;


import java.util.HashSet;
import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc:
 * Date: 30 August 2020
 */

public class GroupRepositoryImpl implements GroupRepository {

    private static GroupRepository repository = null;
    private Set <Group> groupDB;

    private GroupRepositoryImpl () {this.groupDB = new HashSet<>();
    }

    public static GroupRepository getRepository() {

        if (repository == null)
            repository = new GroupRepositoryImpl();
        return repository;
    }



    @Override
    public Set<Group> getAll() {
        return this.groupDB;
    }

    @Override
    public Group create(Group group) {
        this.groupDB.add(group);
        return group;
    }

    @Override
    public Group read(Integer id) {
        for(Group group : this.groupDB){
            if(group.getId() == id )
                return group;
        }

        return null;
    }

    @Override
    public Group update(Group group) {

        boolean deletePoll = delete(group.getId());

        if (deletePoll) {
            this.groupDB.add(group);
            return group;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {

        Group group = read(id);

        if(group != null){
            this.groupDB.remove(group);
            return true;
        }
        return false;
    }
}

