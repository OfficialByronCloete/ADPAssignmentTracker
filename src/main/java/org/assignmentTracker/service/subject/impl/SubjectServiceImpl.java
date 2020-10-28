package org.assignmentTracker.service.subject.impl;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * SubjectServiceImpl.
 */

import org.assignmentTracker.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.assignmentTracker.repository.subject.ISubjectRepository;
import org.assignmentTracker.service.subject.ISubjectService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private ISubjectRepository Repository ;


    @Override
    public Set<Subject> getAll() {
        return this.Repository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Set<Subject> getAllLectureThatStartWithA() {
        Set<Subject> subjects =getAll();
        Set<Subject> LecturesWithA = new HashSet<>();
        for(Subject subject : subjects){

            if ( subject.getLecture().trim().toLowerCase().startsWith("a")){
                LecturesWithA.add(subject);
            }

        }
        return LecturesWithA;
    }

    @Override
    public Subject create(Subject subject) {
        return this.Repository.save(subject);
    }

    @Override
    public Subject read(Integer Id) {
        return this.Repository.findById(Id).orElseGet(null);
    }

    @Override
    public Subject update(Subject subject) {
        return this.Repository.save(subject);
    }

    @Override
    public boolean delete(Integer Id) {
        this.Repository.deleteById(Id);
        if (this.Repository.existsById(Id)) return false;
        return true;
    }

}
