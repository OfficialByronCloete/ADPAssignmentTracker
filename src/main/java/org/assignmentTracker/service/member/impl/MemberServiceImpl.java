package org.assignmentTracker.service.member.impl;

/**
 * @author Justin Kokolo
 * student number: 218044194
 * Desc: member interface implematation
 * Date: 04 September 2020
 */


import org.assignmentTracker.entity.Member;
import org.assignmentTracker.entity.Subject;
import org.assignmentTracker.repository.member.MemberRepository;
import org.assignmentTracker.repository.member.impl.MemberRepositoryImpl;
import org.assignmentTracker.service.member.IMemberService;

import java.util.HashSet;
import java.util.Set;

public class MemberServiceImpl implements IMemberService {

    private static IMemberService service = null;
    private MemberRepository repository;

    public  MemberServiceImpl(){

        this.repository = MemberRepositoryImpl.getRepository();
    }

    public static IMemberService  getService(){
        if(service == null) service = new MemberServiceImpl();
        return service;
    }


    @Override
    public Set<Member> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Member> getAllNamesThatStartWithK() {

        Set<Member> member =getAll();
        Set<Member> MembersWith1 = new HashSet<>();
        for(Member  m : member){

            if ( m.getAssignment_id() == 123){
                MembersWith1.add(m);
            }

        }
        return MembersWith1;

    }

    @Override
    public Member create(Member member) {

        return this.repository.create(member);
    }

    @Override
    public Member read(Integer id) {

        return this.repository.read(id);
    }

    @Override
    public Member update(Member member) {

        return this.repository.update(member);
    }

    @Override
    public boolean delete(Integer id) {

        return this.repository.delete(id) ;
    }
}
