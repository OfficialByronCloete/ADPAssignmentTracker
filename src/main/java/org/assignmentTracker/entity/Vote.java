package org.assignmentTracker.entity;


import java.io.Serializable;

/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: Entity/Vote object for vote
 * Date: 5 July 2020
 */
public class Vote {

    //Variables
    private int id;
    private User voter;

    //constructor
    private Vote() {}

    private Vote(Builder builder) {
        this.id = builder.id;
        this.voter = builder.voter;
    }

    public int getId() {
        return id;
    }

    public User getVoter() {
        return voter;
    }

    public static class Builder {

        private int id;
        private User voter;

        public Builder() {

        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setVoter(User voter) {
            this.voter = voter;
            return this;
        }

        public Vote build() {
            Vote vote = new Vote();
            vote.id = this.id;
            vote.voter = this.voter;

            return vote;
        }

        public Builder copy(Vote vote) {
            this.id = vote.id;
            this.voter = vote.voter;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", voter=" + voter +
                '}';
    }
}
