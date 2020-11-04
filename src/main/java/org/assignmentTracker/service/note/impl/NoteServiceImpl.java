package org.assignmentTracker.service.note.impl;

/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * NoteServiceImpl class
 */

import org.assignmentTracker.entity.Note;
import org.assignmentTracker.repository.note.INoteRepository;
import org.assignmentTracker.service.note.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements INoteService {

    @Autowired
    private INoteRepository Repository ;


    @Override
    public Set<Note> getAll() {
        return this.Repository.findAll().stream().collect(Collectors.toSet());
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
        return this.Repository.save(note);
    }

    @Override
    public Note read(Integer Id) {
        return this.Repository.findById(Id).orElseGet(null);
    }

    @Override
    public Note update(Note note) {
        return this.Repository.save(note);
    }

    @Override
    public boolean delete(Integer Id) {
        this.Repository.deleteById(Id);
        return !this.Repository.existsById(Id);
    }

}
