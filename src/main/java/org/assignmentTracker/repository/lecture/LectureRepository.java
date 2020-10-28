package org.assignmentTracker.repository.lecture;

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc:
 * Date: 28 August 2020
 */

public interface LectureRepository extends IRepository<Lecture,Integer> {

    Set<Lecture> getAll();
}
