package org.assignmentTracker.service.group;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.service.IService;

import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: GroupService interface
 * Date: 06 September 2020
 */

public interface GroupService extends IService <Group, Integer> {

    Set <Group> getAll();
}
