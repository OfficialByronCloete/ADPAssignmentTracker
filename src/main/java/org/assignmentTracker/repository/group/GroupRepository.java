package org.assignmentTracker.repository.group;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc:
 * Date: 30 August 2020
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {



}
