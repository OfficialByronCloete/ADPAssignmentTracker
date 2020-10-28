package org.assignmentTracker.repository.poll;

import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc:
 * Date: 30 August 2020
 */
@Repository
public interface PollRepository extends JpaRepository<Poll,Integer> {


}
