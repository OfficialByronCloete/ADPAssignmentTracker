package org.assignmentTracker.factoryTest;

import org.assignmentTracker.entity.Note;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.factory.NoteFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;


/*
 @author Lyse-Celeste Irakoze
 StudNo: 217132057
 Date: 30 June 2020
 Desc: Note Factory
  */

public class NoteFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createNote() {
        Date dateCreated = new Date();
        Date date= new Date();
        User creator = UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com");

        Note note = NoteFactory.createNote("Chapter 1", "Summary_01",creator, dateCreated);
        Note note1 = NoteFactory.createNote("Chapter 1", "Summary_02",creator ,dateCreated);
        Assert.assertSame(note.getClass(),note1.getClass());
        Assert.assertEquals(creator,note1.getCreator());
    }
}