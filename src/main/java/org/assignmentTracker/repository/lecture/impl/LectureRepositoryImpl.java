package org.assignmentTracker.repository.lecture.impl;

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.repository.lecture.LectureRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: implematation of lecture Repository class
 * Date: 28 August 2020
 */

public class LectureRepositoryImpl implements LectureRepository {

    private static LectureRepositoryImpl repository = null;
    private Set<Lecture> lectureDB;

    public LectureRepositoryImpl() {
        this.lectureDB = new HashSet<Lecture>();
    }

    public static LectureRepositoryImpl getRepository() {
        if (repository == null) repository = new LectureRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Lecture> getAll() {
        return this.lectureDB;
    }

    @Override
    public Lecture create(Lecture lecture) {
        this.lectureDB.add(lecture);
        return lecture;
    }

    @Override
    public Lecture read(Integer id) {
        for (Lecture lecture : this.lectureDB) {
            if (lecture.getId() == id)
                return lecture;
        }

        return null;
    }

    @Override
    public Lecture update(Lecture lecture) {
        boolean deleteLecture = delete(lecture.getId());

        if (deleteLecture) {
            this.lectureDB.add(lecture);
            return lecture;
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Lecture lecture = read(id);

        if (lecture != null) {
            this.lectureDB.remove(lecture);
            return true;
        }

        return false;
    }

}
