package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.factory.SubjectFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/*
@author Lyse-Celeste Irakoze
StudNo: 217132057
Date: 30 June 2020
Desc: test Subject Factory
 */

public class SubjectFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createSubject() {

        Date dates = new Date();
        Subject subject = SubjectFactory.createSubject("Applications Development Practice","ADP(362S)","DDD Chapter 1",dates);
        Subject subject1 = SubjectFactory.createSubject("Applications Development Theory","ADT(362S)","Agile Development Chapter 2",dates);
        Assert.assertSame(subject, subject);
        Assert.assertNotNull(subject);
        Assert.assertTrue(subject!=subject1);

    }
}