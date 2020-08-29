package org.assignmentTracker.factory;

import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.util.Helper;
import java.util.Date;

/*
@author Lyse-Celeste Irakoze
StudNo: 217132057
Date: 30 June 2020
Desc: Subject Factory
 */

public class SubjectFactory {
    public static  Subject createSubject( String name, String code, String lecture, Date dates){
        int subjectID = Helper.generateID();
        Subject subject = new Subject.Builder().
                setId(subjectID).
                setName(name).
                setCode(code).
                setLecture(lecture).
                setDate(dates).
                build();
        return subject;
    }
}
