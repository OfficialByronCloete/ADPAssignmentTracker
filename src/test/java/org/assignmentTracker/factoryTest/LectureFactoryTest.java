package org.assignmentTracker.factoryTest;
/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Test class for Lecture
 * Date: 05 July 2020
 */

import org.assignmentTracker.entity.Lecture;
import org.assignmentTracker.factory.LectureFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LectureFactoryTest {

    @Test
    public void newLecture() {

        Lecture lecture = LectureFactory.newLecture("Justin", "Kokolo", "Justi@gmail.com", "0978499", "4");
        Lecture lecture1 =  LectureFactory.newLecture("Justin","Kokolo","Justi@gmail.com","0978499","4");

        Assert.assertSame(lecture,lecture1);
    }
}