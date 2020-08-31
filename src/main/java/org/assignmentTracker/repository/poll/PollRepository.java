package org.assignmentTracker.repository.poll;

import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc:
 * Date: 30 August 2020
 */

public interface PollRepository extends IRepository<Poll, Integer> {

    Set<Poll> getAll();
}
