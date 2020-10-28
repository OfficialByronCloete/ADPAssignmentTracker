package org.assignmentTracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Poll {

    @Id
    private int id;

    @OneToMany
    private List<Choice> choices;

    @OneToOne
    private User createdBy;

    @OneToOne
    private Member voters;
    private String votes;

    protected Poll(){}


    public Poll  (Builder builder){
        this.id = builder.id;
        this.choices = builder.choices;
        this.createdBy = builder.createdBy;
        this.voters = builder.voters;
        this.votes = builder.votes;

    }
    public static class Builder{

        private int id;
        private List<Choice> choices;
        private User createdBy;
        private Member voters;
        private String votes;

        public Builder setId(int id) {
            this.id = id;
            return this;

        }

        public Builder setChoices(List<Choice> choices) {
            this.choices = choices;
            return this;
        }

        public Builder setCreatedBy(User createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder setVoters(Member voters) {
            this.voters = voters;
            return this;
        }

        public Builder setVotes(String votes){
            this.votes = votes;
            return this;
        }

        public Builder copy(Poll poll){

            this.id = poll.id;
            this.choices = poll.choices;
            this.createdBy = poll.createdBy;
            this.voters = poll.voters;
            this.votes = poll.votes;
            return this;
        }

        public Poll build(){
            return new Poll(this);
        }

    }

    public int getId() {
        return id;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Member getVoters() {
        return voters;
    }

    public String getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id='" + id + '\'' +
                ", choices=" + choices +
                ", createdBy=" + createdBy +
                ", voters=" + voters +
                ", votes='" + votes + '\'' +
                '}';
    }


}
