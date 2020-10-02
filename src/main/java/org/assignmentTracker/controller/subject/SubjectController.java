package org.assignmentTracker.controller.subject;


/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Subject Controller class
 */

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.service.subject.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/subject")

public class SubjectController {


    @Autowired
    private SubjectServiceImpl subjectService;

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject) {
        Subject newSubject = SubjectFactory.createSubject(subject.getName(),subject.getCode(),subject.getLecture(),subject.getDates());
        return subjectService.create(newSubject);
    }

    @GetMapping("/read/{id}")
    public Subject read(@PathVariable int id) {
        return subjectService.read(id);
    }

    @PutMapping("/update")
    public Subject update(@RequestBody Subject subject) {
        return subjectService.update(subject);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        subjectService.delete(id);
    }

    @GetMapping("/all")
    public Set<Subject> getAll() {
        return subjectService.getAll();
    }

}