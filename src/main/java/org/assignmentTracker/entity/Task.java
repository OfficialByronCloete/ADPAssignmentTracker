package org.assignmentTracker.entity;

import java.util.List;

public class Task {
    private int taskId, assignmentId, memberId;
    private long students;

    private Task() {
    }

    public int getTaskId() {
        return taskId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public long getStudents() {
        return students;
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

        public Builder setStudents(long students) {
            this.students = students;
            return this;
        }
        public Task build() {
            Task task = new Task();
            task.assignmentId = this.assignmentId;
            task.memberId = this.memberId;
            task.taskId = this.taskId;
            task.students = this.students;

            return build();
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskId=" + taskId +
                ", AssignmentId=" + assignmentId +
                ", MemberId=" + memberId +
                ", students=" + students +
                '}';
    }
}
