package org.assignmentTracker.entity;


import javax.persistence.*;
import java.util.Objects;

/**
 * @author Claude De-Tchambila
 * student number: 217035027
 * Desc: Entity/Vote object for vote
 * Date: 5 July 2020
 */
@Entity
@Embeddable
public class Vote {

    @Id
    private int id;

    @OneToOne
    private User voter;

    protected Vote() {}

    private Vote(Builder builder) {
        this.id = builder.id;
        this.voter = builder.voter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVoter(User voter) {
        this.voter = voter;
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
            return new Vote(this);
        }

        public Builder copy(Vote vote) {
            this.id = vote.id;
            this.voter = vote.voter;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id &&
                voter.equals(vote.voter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voter);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", voter=" + voter +
                '}';
    }
}
