package org.assignmentTracker.serviceTest;
/**
 * @author : Lyse-Celeste Irakoze
 * Student Number : 217132057
 * Date : 03 September 2020
 * Test class for NoteServiceImpl
 */
import org.assignmentTracker.entity.Note;
import org.assignmentTracker.factory.NoteFactory;
import org.assignmentTracker.factory.UserFactory;
import org.assignmentTracker.service.note.INoteService;
import org.assignmentTracker.service.note.impl.NoteServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Date;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoteServiceImplTest {

    private static INoteService service = NoteServiceImpl.getService();
   private static Note note = NoteFactory.createNote("Chapter 101", "Summary", UserFactory.createUser("Byron", "Cloete", "wordpass", "byroncloete7@gmail.com"), new Date());
   private static Note note1 = NoteFactory.createNote("Chater 102", "Core Notes", UserFactory.createUser("Lyse", "Irakoze", "pass", "iraLyse@gmail.com"), new Date());
   private static Note note2 = NoteFactory.createNote("Chapter 103", "keyword", UserFactory.createUser("John", "Doe", "jdoes", "JohnDoe@gmail.com"), new Date());

    @Test
    public void A_create() {

        Note created = service.create(note);
        Note created1 = service.create(note1);
        Note created2 = service.create(note2);

        Assert.assertEquals(note.getId(),created.getId());
        Assert.assertEquals(note1.getId(),created1.getId());
        Assert.assertEquals(note2.getId(),created2.getId());

        System.out.println( created+ "\n" + created1 + "\n" + created2 + "\n created \n");
    }

    @Test
    public void b_read() {
        Note read = service.read(note.getId());
        System.out.println( read+ "\n read \n" );
    }

    @Test
    public void c_update() {
        Note updated = new Note.Builder().copy(note).setText("Chapter 102").build();
        updated = service.update(updated);
        System.out.println(  updated + "\n Updated \n" );
    }

    @Test
    public void e_getAllTextsThatStartWithK() {

        System.out.println("\n Texts that starts with K : \n" + service.getAllTextsThatStartWithK());
    }

    @Test
    public void f_getAll() {
        System.out.println( "\n" + service.getAll() + "\n This is Everything \n" );
    }

    @Test
    public void g_delete() {
        boolean deleted = service.delete(note.getId());
        Assert.assertTrue(deleted);
    }
}