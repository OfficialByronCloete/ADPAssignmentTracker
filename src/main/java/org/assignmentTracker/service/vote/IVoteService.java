package org.assignmentTracker.service.vote;

import org.assignmentTracker.entity.Vote;
import org.assignmentTracker.service.IService;

import java.util.Set;

/**
 * IVoteService.java
 * Vote service interface
 * Date: 06 August 2020
 * @author Claude Christ De-Tchambila
 * student number: 217035027
 */
public interface IVoteService extends IService<Vote, Integer> {
    Set<Vote> getAll();
}