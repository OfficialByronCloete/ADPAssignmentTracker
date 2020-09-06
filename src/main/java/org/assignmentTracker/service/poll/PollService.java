package org.assignmentTracker.service.poll;

import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.service.IService;

import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Interface of GroupService
 * Date: 06 September 2020
 */
public interface PollService extends IService <Poll, Integer> {

    Set<Poll> getAll();
}
