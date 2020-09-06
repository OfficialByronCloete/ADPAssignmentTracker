package org.assignmentTracker.service.lecture;

/*
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: lecture interface interface
 * Date: 04 September 2020
 */

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.service.IService;
import java.util.Set;



public interface ILectureService extends IService <Lecture,Integer> {

    Set<Lecture> getAll();
    Set<Lecture> getAllNamesThatStartWithK();
}