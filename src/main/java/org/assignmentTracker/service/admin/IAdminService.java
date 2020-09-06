package org.assignmentTracker.service.admin;

import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IAdminService extends IService<Admin, Integer> {

    Set<Admin> getAll();
    Set<Admin> getIdGreaterThen500000000();

}
