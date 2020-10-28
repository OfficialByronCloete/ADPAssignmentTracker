package org.assignmentTracker.repository.member.impl;

import org.assignmentTracker.entity.Member;
import org.assignmentTracker.repository.member.MemberRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: implematation of member repository class
 * Date: 28 August 2020
 */

/*public class MemberRepositoryImpl implements MemberRepository {

    private static MemberRepositoryImpl repository = null;
    private Set<Member> memberDB;


    public MemberRepositoryImpl() {
        this.memberDB = new HashSet<Member>();
    }

    public static MemberRepositoryImpl getRepository() {
        if (repository == null) repository = new MemberRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Member> getAll() {
        return this.memberDB;
    }

    @Override
    public Member create(Member member) {
        this.memberDB.add(member);
        return member;
    }

    @Override
    public Member read(Integer id) {
        for (Member member : this.memberDB) {

            if (member.getId() == id)
                return member;
        }


        return null;
    }

    @Override
    public Member update(Member member) {
        boolean deleteLecture = delete(member.getId());

        if (deleteLecture) {
            this.memberDB.add(member);
            return member;
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Member member = read(id);

        if (member != null) {
            this.memberDB.remove(member);
            return true;
        }

        return false;
    }



/}*/