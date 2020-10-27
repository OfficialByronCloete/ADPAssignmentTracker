package org.assignmentTracker.repositoryTest;

import org.assignmentTracker.entity.Member;
import org.assignmentTracker.factory.MemberFactory;
import org.assignmentTracker.repository.member.MemberRepository;
//import org.assignmentTracker.repository.member.impl.MemberRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: class that test Member repository impl
 * Date: 28 August 2020
 */

/*@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MemberRepositoryImplTest {


    private static MemberRepository repository = MemberRepositoryImpl.getRepository();
    private static Member member = MemberFactory.createMember(9);


    @Test
    public void a_create() {

        Member newMember = repository.create(member);
        Assert.assertEquals(newMember.getId(), member.getId());
        System.out.println("Created: " + newMember);
    }

    @Test
    public void b_read() {
        Member read = repository.read(member.getId());
        System.out.println(" " + read);
    }

    @Test
    public void c_update() {

        Member updateMember = MemberFactory.createMember(8);
        Member update = new Member.Builder().copy(updateMember).setAssignment_id(902820).build();
        update = repository.update(update);

        System.out.println("Updated: " + update);
    }

    @Test
    public void d_delete() {

        boolean deleteMember = repository.delete(member.getId());
        Assert.assertTrue(deleteMember);
    }


    @Test
    public void e_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }
}*/