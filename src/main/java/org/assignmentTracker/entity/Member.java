package org.assignmentTracker.entity;

/**
 * @author  @JustinKokolo
 * Student Number: 218044194
 * Desc: Test entity class for member
 * Date: 05 July 2020
 */


public class Member {

    private int id;
    private int  assignment_id ;

    private  Member(){

    }

    public Member(Builder builder) {
        this.id = builder.id;
        this.assignment_id = builder.assignment_id;
    }

    public int getId() {
        return id;
    }

    public int getAssignment_id() {
        return assignment_id;
    }



    public static class Builder{

        int id;
        int assignment_id ;

        public Builder() {
        }

        public Builder setId(int id){

            this.id = id ;
            return  this;
        }
        public Builder setAssignment_id(int assignment_id){

            this.assignment_id = assignment_id ;
            return  this;
        }

        public Member build(){

            Member member = new Member();
            member.id = this.id;
            member.assignment_id = this.assignment_id;

            return member;
        }


        public Builder copy(Member member){

            this.id = member.id;
            this.assignment_id = member.assignment_id;
            return this;
        }

    }//end of builder

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", assignment_id=" + assignment_id +
                '}';
    }
}//end of Member class
