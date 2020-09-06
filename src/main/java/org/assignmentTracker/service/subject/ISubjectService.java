package org.assignmentTracker.service.subject;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 *  SubjectService interface
 */

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.service.IService;
import java.util.Set;

public interface ISubjectService extends IService<Subject, Integer> {

    Set<Subject> getAll();
    Set<Subject> getAllLectureThatStartWithA();
}
