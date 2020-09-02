package org.assignmentTracker.service.choice;

import org.assignmentTracker.entity.Choice;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IChoiceService extends IService<Choice, Integer> {
    Set<Choice> getAll();
}
