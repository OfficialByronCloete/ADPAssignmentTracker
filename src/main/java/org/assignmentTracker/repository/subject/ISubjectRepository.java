package org.assignmentTracker.repository.subject;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 30 August 2020
 * ISubjectRepository interface
 */

import org.assignmentTracker.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;
@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Integer> {


}
