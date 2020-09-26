package org.assignmentTracker.controller;

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.service.subject.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public class SubjectController {

    @Autowired
private SubjectServiceImpl subjectService;

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject){
    Subject newSubject = SubjectFactory.createSubject(subject.getName(),subject.getCode(),subject.getLecture(),subject.getDates());
    return subjectService.create(newSubject);
    }


@GetMapping("/read/{id}")
    public Subject read(@PathVariable Integer id){
        return subjectService.read(id);
    };

@PostMapping("/update")
    public  Subject update(@RequestBody Subject subject){
           return subjectService.update(subject);
     }

     @GetMapping("/all")
    public Set<Subject> getall()
    {
        return subjectService.getAll();
    }


    @DeleteMapping("/delete/{id};")
    public boolean delete(@PathVariable Integer id) {
    return subjectService.delete(id);
}


}
