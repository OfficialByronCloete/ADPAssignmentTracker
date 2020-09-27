package org.assignmentTracker.service.note.impl;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * NoteServiceImpl class
 */

import org.assignmentTracker.entity.Note;
import org.assignmentTracker.repository.note.impl.NoteRepositoryImpl;
import org.assignmentTracker.service.note.INoteService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class NoteServiceImpl implements INoteService {

    private static INoteService service = null;
    private NoteRepositoryImpl Repository ;

    private NoteServiceImpl(){
        this.Repository = NoteRepositoryImpl.getRepository();
    }

    public static INoteService getService(){
        if(service == null) service = new NoteServiceImpl();
        return service;
    }

    @Override
    public Set<Note> getAll() {
        return this.Repository.getAll();
    }

    @Override
    public Set<Note> getAllTextsThatStartWithK() {
        Set<Note> Notes =getAll();
        Set<Note> TextsWithK = new HashSet<>();
        for(Note note : Notes){

            if ( note.getText().trim().toLowerCase().startsWith("k")){
                TextsWithK.add(note);
            }

        }
        return TextsWithK;
    }

    @Override
    public Note create(Note note) {
        return this.Repository.create(note);
    }

    @Override
    public Note read(Integer Id) {
        return this.Repository.read(Id);
    }

    @Override
    public Note update(Note note) {
        return this.Repository.update(note);
    }

    @Override
    public boolean delete(Integer Id) {
        return this.Repository.delete(Id);
    }

}
