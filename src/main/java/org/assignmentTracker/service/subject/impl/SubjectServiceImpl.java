package org.assignmentTracker.service.subject.impl;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * SubjectServiceImpl.
 */

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.repository.subject.impl.SubjectRepositoryImpl;
import org.assignmentTracker.service.subject.ISubjectService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SubjectServiceImpl implements ISubjectService {

    private static ISubjectService service = null;
    private SubjectRepositoryImpl Repository ;

    private SubjectServiceImpl(){
        this.Repository = SubjectRepositoryImpl.getRepository();
    }

    public static ISubjectService getService(){
        if(service == null) service = new SubjectServiceImpl();
        return service;
    }

    @Override
    public Set<Subject> getAll() {
        return this.Repository.getAll();
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
        return this.Repository.create(subject);
    }

    @Override
    public Subject read(Integer Id) {
        return this.Repository.read(Id);
    }

    @Override
    public Subject update(Subject subject) {
        return this.Repository.update(subject);
    }

    @Override
    public boolean delete(Integer Id) {
        return this.Repository.delete(Id);
    }

}
