//package org.assignmentTracker.repository.note.impl;
//
///**
// * @author : Lyse-Celeste Irakoze
// * Student Number : 217132057
// * Date : 30 August 2020
// * class NoteRepositoryImpl
// *
// */
//
//import org.assignmentTracker.entity.Note;
//import org.assignmentTracker.repository.note.INoteRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class NoteRepositoryImpl implements INoteRepository {
//
//    private static NoteRepositoryImpl repository = null;
//    private Set<Note> noteDB;
//
//    private NoteRepositoryImpl() {this.noteDB = new HashSet<>();}
//
//    public static NoteRepositoryImpl getRepository() {
//        if (repository == null) repository = new NoteRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Set<Note> getAll() {
//        return noteDB;
//    }
//
//    @Override
//    public Note create(Note note) {
//        this.noteDB.add(note);
//        return note;
//    }
//
//    @Override
//    public Note read(Integer id) {
//        for (Note note: this.noteDB) {
//            if (note.getId() == id);
//            return note;
//        }
//        return null;
//    }
//
//    @Override
//    public Note update(Note note) {
//        boolean deleteNote = delete(note.getId());
//        if (deleteNote){
//            this.noteDB.add(note);
//            return note;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(Integer id) {
//        Note note = read(id);
//        if (note != null){
//            this.noteDB.remove(note);
//            return true;
//        }
//        return false;
//    }
//}
