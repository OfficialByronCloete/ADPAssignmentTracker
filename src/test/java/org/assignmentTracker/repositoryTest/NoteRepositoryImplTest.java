//package org.assignmentTracker.repositoryTest;
//
///**
// * @author : Lyse-Celeste Irakoze
// * Student Number : 217132057
// * Date : 30 August 2020
// * Test class for NoteRepositoryImpl
// */
//
//import org.assignmentTracker.entity.Note;
//import org.assignmentTracker.factory.NoteFactory;
//import org.assignmentTracker.factory.UserFactory;
//import org.assignmentTracker.repository.note.impl.NoteRepositoryImpl;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Date;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class NoteRepositoryImplTest {
//
//    private static NoteRepositoryImpl repository = NoteRepositoryImpl.getRepository();
//    private static Note note = NoteFactory.createNote("Chapter 101", "Summary", UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com"), new Date());
//
//    @Test
//    public void a_create() {
//        Note created = repository.create(note);
//        Assert.assertEquals(created.getId(), note.getId());
//        System.out.println(created + ": created \n");
//    }
//
//    @Test
//    public void b_read() {
//
//        Note read = repository.read(note.getId());
//        System.out.println(read + " : Read  \n");
//    }
//
//    @Test
//    public void c_update() {
//
//        Note updated = new Note.Builder().copy(note).setDescription("Chapter 9").build();
//        updated = repository.update(updated);
//        System.out.println(updated + " : updated \n");
//    }
//
//    @Test
//    public void d_getAll() {
//        System.out.println(repository.getAll() + ": Is everything \n");
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(note.getId());
//        Assert.assertTrue(deleted);
//    }
//}
