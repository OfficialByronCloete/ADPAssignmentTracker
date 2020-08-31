package org.assignmentTracker.repository.group;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc:
 * Date: 30 August 2020
 */

public interface GroupRepository extends IRepository<Group, Integer> {

    Set<Group> getAll();

}
