package org.assignmentTracker.service.note;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * NoteServices interface
 */

import org.assignmentTracker.entity.Note;
import org.assignmentTracker.service.IService;
import java.util.Set;

public interface INoteService extends IService<Note, Integer> {

    Set<Note> getAll();
    Set<Note> getAllTextsThatStartWithK();
}
