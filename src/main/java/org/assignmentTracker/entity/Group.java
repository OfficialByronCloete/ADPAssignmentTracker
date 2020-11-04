package org.assignmentTracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Group {

    @Id
    private int id;
    private String name;
    private String lecture;
    private String subject;

    protected Group() {}

    public Group (Builder builder){
        this.id = builder.id;
        this.name= builder.name;
        this.lecture = builder.lecture;
        this.subject = builder.subject;

    }



    public static class Builder{

        private int id;
        private String name;
        private String lecture;
        private String subject;

        public Builder setId(int id) {
            this.id = id;
            return this;

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLecture(String lecture) {
            this.lecture = lecture;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder copy(Group group){

            this.id = group.id;
            this.name =group.name;
            this.lecture = group.lecture;
            this.subject = group.subject;
            return this;
        }

        public Group build(){

            return new Group(this);}

    }


    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getLecture() {

        return lecture;
    }

    public String getSubject() {

        return subject;
    }




    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lecture=" + lecture +
                ", subject=" + subject +
                '}';
    }
}
