package org.assignmentTracker.controller.admin;

import org.assignmentTracker.entity.Admin;
import org.assignmentTracker.factory.AdminFactory;
import org.assignmentTracker.service.admin.impl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/*
@author Brandon Villet
StudNo: 214056791
Date: 27 September 2020
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin){
        Admin newAdmin = AdminFactory.createAdmin(
                admin.getUser(),
                admin.getAssignment());

        return adminService.create(newAdmin);
    }

    @GetMapping("/read/{id}")
    public Admin read(@PathVariable int id){
        return adminService.read(id);
    }

    @PutMapping("/update")
    public Admin update(@RequestBody Admin admin){
        return adminService.update(admin);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        adminService.delete(id);
    }

    @GetMapping("/all")
    public Set<Admin> getAll(){
        return adminService.getAll();
    }

}
