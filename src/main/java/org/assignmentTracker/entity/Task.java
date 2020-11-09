package org.assignmentTracker.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 * @author: Caleb Ruiters
 * student number: 215169751
 * */

@Entity
@Embeddable
public class Task {
    @Id
    private int taskId;
    private int assignmentId;
    private int memberId;
    private long studentId;

    protected Task() {
    }

    public int getTaskId() {
        return taskId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public static class Builder{
        private int taskId, assignmentId, memberId;
        private long students;

        public Builder setTaskId(int taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder setAssignmentId(int assignmentId) {
            this.assignmentId = assignmentId;
            return this;
        }

        public Builder setMemberId(int memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder setStudentId(long students) {
            this.students = students;
            return this;
        }
        public Task build() {
            Task task = new Task();
            task.assignmentId = this.assignmentId;
            task.memberId = this.memberId;
            task.taskId = this.taskId;
            task.studentId = this.students;

            return build();
        }

        public Builder copy(Task task) {
            task.assignmentId = this.assignmentId;
            task.memberId = this.memberId;
            task.taskId = this.taskId;
            task.studentId = this.students;

            return this;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskId=" + taskId +
                ", AssignmentId=" + assignmentId +
                ", MemberId=" + memberId +
                ", students=" + studentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
