package org.assignmentTracker.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: Entity/Assignment object for assignment
 * Date: 5 July 2020
 */
public class Assignment {

    private int id;
    private String name;
    private Subject subject;
    private Date dateAssigned;
    private List<Admin> admins;
    private List<Member> members;
    private User creator;

    private Assignment() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Member> getMembers() {
        return members;
    }

    public User getCreator() {
        return creator;
    }

    public static class Builder {
        private int id;
        private String name;
        private Subject subject;
        private Date dateAssigned;
        private List<Admin> admins;
        private List<Member> members;
        private User creator;

        public Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCreator(User creator) {
            this.creator = creator;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder setDateAssigned(Date dateAssigned) {
            this.dateAssigned = dateAssigned;
            return this;
        }

        public Builder setAdmins(List<Admin> admins) {
            this.admins = admins;
            return this;
        }

        public Builder setMembers(List<Member> members) {
            this.members = members;
            return this;
        }

        public Assignment build() {
            Assignment assignment = new Assignment();
            assignment.id = this.id;
            assignment.name = this.name;
            assignment.subject = this.subject;
            assignment.dateAssigned = this.dateAssigned;
            assignment.admins = this.admins;
            assignment.members = this.members;
            assignment.creator = this.creator;

            return assignment;
        }

        public Builder copy(Assignment assignment) {
            this.id = assignment.id;
            this.name = assignment.name;
            this.subject = assignment.subject;
            this.dateAssigned = assignment.dateAssigned;
            this.admins = assignment.admins;
            this.members = assignment.members;
            this.creator = assignment.creator;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", dateAssigned=" + dateAssigned +
                ", admins=" + admins +
                ", members=" + members +
                ", creator=" + creator +
                '}';
    }
}
