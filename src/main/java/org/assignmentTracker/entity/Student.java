package org.assignmentTracker.entity;

public class Student {
    private long studentNumber;
    private String name;
    private String surname;

    private Student(){

    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static class Builder{
        private long studentNumber;
        private String name;
        private String surname;

        public Builder setStudentNumber(long studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Student build(){
            Student student = new Student();
            student.name = this.name;
            student.studentNumber = this.studentNumber;
            student.surname = this.surname;
            return build();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                '}';
    }
}
