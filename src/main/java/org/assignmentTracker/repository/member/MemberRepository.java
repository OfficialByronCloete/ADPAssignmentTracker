package org.assignmentTracker.repository.member;

import org.assignmentTracker.entity.Member;
import org.assignmentTracker.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: member interface
 * Date: 28 August 2020
 */

@Repository
public interface MemberRepository extends JpaRepository<Member , Integer> {

    //Set<Member> getAll();
}