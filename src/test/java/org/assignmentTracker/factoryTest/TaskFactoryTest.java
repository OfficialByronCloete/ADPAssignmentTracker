package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Task;
import org.assignmentTracker.factory.TaskFactory;
import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTest {

    @Test
    public void createTask() {
        Task prerequisite = TaskFactory.newTask(1,215169751,5);
        Task requisite = TaskFactory.newTask(3, 215141210, 1);

        Assert.assertNotSame(requisite, prerequisite);

    }
}
