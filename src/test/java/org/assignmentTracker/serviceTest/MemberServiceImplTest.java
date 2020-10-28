package org.assignmentTracker.serviceTest;


import org.assignmentTracker.entity.Member;
import org.assignmentTracker.factory.MemberFactory;
import org.assignmentTracker.service.member.IMemberService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: test class member sercvice impl
 * Date: 04 September 2020
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceImplTest {

    @Autowired
    private static IMemberService service ;
    private static Member member_1 = MemberFactory.createMember(2);
    private static Member member_2 = MemberFactory.createMember(5);
    private static Member member_3 = MemberFactory.createMember(6);



    @Test
    public void a_create() {


        Member created_1 = service.create(member_1);
        Member created_2 = service.create(member_2);
        Member created_3 = service.create(member_3);
        Assert.assertEquals(member_1.getId(), created_1.getId());
        Assert.assertEquals(member_2.getId(), created_2.getId());
        Assert.assertEquals(member_3.getId(), created_3.getId());
        System.out.println(("Created: " + created_1 + "\n" + created_2 + "\n" + created_3));
    }

    @Test
    public void b_read() {
        Member read = service.read(member_1.getId());
        System.out.println("Created: " + read);
    }

    @Test
    public void c_update() {
        Member updated = new Member.Builder().copy(member_1).setAssignment_id(4).build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }


    @Test
    public void d_getAll() {
        System.out.println("Get all: " + service.getAll());
    }

    @Test
    public void e_getAllNamesThatStartWithK() {
        System.out.println("Names that start with k:" + service.getAllNamesThatStartWithK());
    }

    @Test
    public void f_delete() {

        boolean deleted = service.delete(member_1.getId());
        Assert.assertTrue(deleted);
    }
}