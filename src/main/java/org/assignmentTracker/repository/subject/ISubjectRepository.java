package org.assignmentTracker.repository.subject;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 30 August 2020
 * ISubjectRepository interface
 */

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

public interface ISubjectRepository extends IRepository<Subject, Integer> {

    Set<Subject> getAll();

}
