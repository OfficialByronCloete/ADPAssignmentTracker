package org.assignmentTracker.service.member;


/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: member service interface
 * Date: 04 September 2020
 */
import org.assignmentTracker.entity.Member;
import org.assignmentTracker.entity.User;
import org.assignmentTracker.service.IService;

import java.util.Set;

public interface IMemberService extends IService<Member, Integer> {

    Set<Member> getAll();
    Set<Member> getAllNamesThatStartWithK();
}
