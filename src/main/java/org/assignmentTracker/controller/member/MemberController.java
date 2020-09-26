package org.assignmentTracker.controller.member;

import org.assignmentTracker.entity.Member;
import org.assignmentTracker.factory.MemberFactory;
import org.assignmentTracker.repository.member.MemberRepository;
import org.assignmentTracker.service.member.imp.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Member controller class that creat , read , update, read.
 * Date: 26 September 2020
 */

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping("/create")
    public Member create (@RequestBody Member member){

        Member newMember = MemberFactory.createMember(member.getAssignment_id());
        return memberService.create(newMember);
    }

    @PostMapping("/read/{id}")
    public Member read(@PathVariable int id){
        return memberService.read(id);
    }

    @PostMapping("/update")
    public Member update (@RequestBody Member member){

        return memberService.update(member);
    }

   @PostMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        memberService.delete(id);
    }
    @GetMapping("/all")
    public Set<Member> getAll(){
        return memberService.getAll();
    }


}
