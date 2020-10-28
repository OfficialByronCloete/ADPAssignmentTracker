package org.assignmentTracker.serviceTest;

import org.assignmentTracker.entity.Group;
import org.assignmentTracker.entity.Poll;
import org.assignmentTracker.factory.PollFactory;
import org.assignmentTracker.repository.poll.PollRepository;
//import org.assignmentTracker.repository.poll.impl.PollRepositoryImpl;
import org.assignmentTracker.service.poll.PollService;
import org.assignmentTracker.service.poll.impl.PollServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
/**
 * @author: Sinovuyo May
 * Student number: 217298915
 * Desc: Test class for PollSercvice
 * Date: 06 September 2020
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PollServiceImplTest {

    @Autowired
    private static PollService service ;
    private static Poll poll = PollFactory.createPoll(null,null,null,"No");

    @Test
    public void d_getAll() {

        Set<Poll> poll = service.getAll();
        assertEquals(1,poll.size());
        System.out.println("Poll"+ poll);
    }

    @Test
    public void a_create() {
        Poll created = service.create(poll);
        Assert.assertEquals(poll.getId() , created.getId());
        System.out.println("Created: "+ created);
    }

    @Test
    public void b_read() {
        Poll read = service.read(poll.getId());
        System.out.println("Read: "+ read);
    }

    @Test
    public void c_update() {

        Poll update = new Poll.Builder().copy(poll).setVotes("Yes").build();
        update = service.update(update);
        System.out.println("Update: "+ update);
    }

    @Test
    public void e_delete() {

        boolean deleted = service.delete(poll.getId());
        Assert.assertTrue(deleted);
    }
}