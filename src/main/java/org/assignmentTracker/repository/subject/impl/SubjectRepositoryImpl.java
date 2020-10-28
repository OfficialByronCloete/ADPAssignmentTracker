/** package org.assignmentTracker.repository.subject.impl;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 30 August 2020
 * class SubjectRepositoryImpl
 * //


import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.repository.subject.ISubjectRepository;

import java.util.HashSet;
import java.util.Set;


public class SubjectRepositoryImpl implements ISubjectRepository {

    private static SubjectRepositoryImpl repository = null;
    private Set<Subject> subjectDB;

    private SubjectRepositoryImpl() {
        this.subjectDB = new HashSet<>();
    }

    public static SubjectRepositoryImpl getRepository() {
        if (repository == null) repository = new SubjectRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Subject> getAll() {
        return subjectDB;
    }

    @Override
    public Subject create(Subject subject) {
        this.subjectDB.add(subject);
        return subject;
    }

    @Override
    public Subject read(Integer id) {
        for (Subject subject : this.subjectDB) {
            if (subject.getId() == id) ;
            return subject;
        }
        return null;
    }

    @Override
    public Subject update(Subject subject) {
        boolean deleteSubject = delete(subject.getId());
        if (deleteSubject) {
            this.subjectDB.add(subject);
            return subject;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Subject subject = read(id);
        if (subject != null) {
            this.subjectDB.remove(subject);
            return true;
        }
        return false;
    }
}
**/