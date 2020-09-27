package org.assignmentTracker.entity;

import java.util.Date;

public class Subject {

    private int id;
    private String name,code,lecture;
    private Date dates;

    private Subject() {}

    private Subject(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.code = builder.code;
        this.lecture = builder.lecture;
        this.dates = builder.dates;

    }// builder constructor

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLecture() {
        return lecture;
    }

    public Date getDates() {
        return dates;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", lecture='" + lecture + '\'' +
                ", dates=" + dates +
                '}';
    }

    public static class Builder{

        private int id;
        private String name,code,lecture;
        private Date dates;

        public Builder setId(int id){
            this.id= id;
            return this;
        }


        public Builder setName(String name){
            this.name= name;
            return this;
        }

        public Builder setCode(String code){
            this.code= code;
            return this;
        }

        public Builder setLecture(String lecture){
            this.lecture= lecture;
            return this;
        }


        public Builder setDate(Date dates){
            this.dates= dates;
            return this;
        }


        public Builder copy(Subject subject){

            this.id = subject.id;
            this.name = subject.name;
            this.code = subject.code;
            this.lecture = subject.lecture;
            this.dates = subject.dates;
            return this;

        } // copy builder method

        public Subject build(){
            return new Subject(this);

        }//build method
    }//static builder
}// class