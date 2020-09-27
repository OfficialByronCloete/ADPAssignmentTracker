package org.assignmentTracker.service.admin.impl;

import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.repository.admin.impl.AdminRepositoryImpl;
import org.assignmentTracker.service.admin.IAdminService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService implements IAdminService{
    private static IAdminService service = null;
    private AdminRepositoryImpl repository;

    private AdminService(){
        this.repository = AdminRepositoryImpl.getRepo();
    }

    public static IAdminService getService(){
        if(service == null) service = new AdminService();
        return service;
    }

    @Override
    public Set<Admin> getAll() {
        return this.repository.getAll();
    }


    @Override
    public Admin create(Admin admin) {
        return this.repository.create(admin);
    }

    @Override
    public Admin read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public Admin update(Admin admin) {
        return this.repository.update(admin);
    }

    @Override
    public boolean delete(Integer integer) {
        return this.repository.delete(integer);
    }
    @Override
    public Set<Admin> getIdGreaterThen500000000() {
        Set<Admin> admins = getAll();
        Set<Admin> largeId = new HashSet<>();
        for(Admin admin : admins){
            if(admin.getId()>500000000){
                largeId.add(admin);
            }
        }
        return largeId;
    }
}
