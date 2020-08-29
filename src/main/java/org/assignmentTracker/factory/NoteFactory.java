package org.assignmentTracker.factory;

import org.assignmentTracker.entity.Note;
import org.assignmentTracker.util.Helper;
import org.assignmentTracker.entity.User;
import java.util.Date;

 /*
 @author Lyse-Celeste Irakoze
 StudNo: 217132057
 Date: 30 June 2020
 Desc: Note Factory
  */

public class NoteFactory {

    public static Note createNote (String description, String text,User creator, Date dateCreated){
        int noteID = Helper.generateID();
        Note note = new Note.Builder().
                setId(noteID).
                setDescription(description).
                setText(text).
                setCreator(creator).
                setDateCreated(dateCreated).
                build();
        return note;
    }
}

