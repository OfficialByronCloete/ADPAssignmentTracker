package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.*;
import org.assignmentTracker.factory.AssignmentFactory;
import org.assignmentTracker.factory.SubjectFactory;
import org.assignmentTracker.factory.UserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class AssignmentFactoryTest {

    @Test
    public void createAssignment() {
        Subject subject = SubjectFactory.createSubject("Application Development Practice", "ADP372S",
                "Arinze Anikwue", new Date(4554564));

        List<Admin> admins = new ArrayList<>();
        List<Member> members = new ArrayList<>();
        User user = UserFactory.createUser("William", "King", "passWill123", "williamK@cput.ac.za");

        Assignment assignment = AssignmentFactory.createAssignment("ADP 372S Domain-Driven Design", subject,
                new Date(4599564), admins, members, user);

        Assert.assertTrue(assignment instanceof Assignment);
    }
}