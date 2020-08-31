package org.assignmentTracker.repository.choice;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.repository.IRepository;

import java.util.Set;

/**
 * @author Anganathi Ngodwane
 * desc: ChoiceRepositoryInterface.java
 * date 31 August 2020 SAST
 * student number: 217078907
 */
public interface ChoiceRepositoryInterface extends IRepository<Choice, Integer> {
    Set<Choice> getAll();
}
