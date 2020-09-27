package org.assignmentTracker.service.lecture.impl;

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.repository.lecture.LectureRepository;
import org.assignmentTracker.repository.lecture.impl.LectureRepositoryImpl;
import org.assignmentTracker.service.lecture.ILectureService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: Lecture service implimatation
 * Date: 04 September 2020
 */

@Service
public class LectureServiceImpl implements ILectureService {


    private static ILectureService service = null;
    private LectureRepository repository;

    public  LectureServiceImpl(){

        this.repository = LectureRepositoryImpl.getRepository();
    }

    public static ILectureService getService(){
        if(service == null) service = new LectureServiceImpl();
        return service;
    }


    @Override
    public Set<Lecture> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Lecture> getAllNamesThatStartWithK() {
        Set<Lecture> lectures =getAll();
        Set<Lecture> LecturesWithK = new HashSet<>();
        for(Lecture lecture : lectures){

            if ( lecture.getName().trim().toLowerCase().startsWith("K")){
                LecturesWithK.add(lecture);
            }

        }
        return LecturesWithK;
    }

    @Override
    public Lecture create(Lecture lecture) {
        return this.repository.create(lecture);
    }

    @Override
    public Lecture read(Integer id) {
        return this.repository.read(id);
    }

    @Override
    public Lecture update(Lecture lecture) {
        return this.repository.update(lecture);
    }

    @Override
    public boolean delete(Integer id) {
        return this.repository.delete(id);
    }
}