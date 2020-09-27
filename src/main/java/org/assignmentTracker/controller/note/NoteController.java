package org.assignmentTracker.controller.note;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Note Controller class
 */


import org.assignmentTracker.entity.Note;
import org.assignmentTracker.factory.NoteFactory;

import org.assignmentTracker.service.note.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/note")

public class NoteController {

    @Autowired
    private NoteServiceImpl noteService;

    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/create")
    public Note create(@RequestBody Note note){

        Note newNote = NoteFactory.createNote(
                note.getDescription(),
                note.getText(),
                note.getCreator(),
                note.getDateCreated());

        return noteService.create(newNote);
    }


    @GetMapping("/read/{id}")
    public Note read(@PathVariable int id){
        return noteService.read(id);
    }

    @PostMapping("/update")
    public  Note update(@RequestBody Note note)
    {
        return noteService.update(note);
    }

    @GetMapping("/all")
    public Set<Note> getall()
    {
        return noteService.getAll();
    }


    @DeleteMapping("/delete/{id};")
    public boolean delete(@PathVariable int id) {
        return noteService.delete(id);
    }


}
