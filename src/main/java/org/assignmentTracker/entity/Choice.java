package org.assignmentTracker.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Choice{

    @Id
    private int id;
    private String name;
    @ElementCollection
    private List <Vote> votes;

    public Choice(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.votes = builder.votes;
    }

    protected Choice() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List <Vote> getVotes() {
        return votes;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", votes=" + this.votes +
                '}';
    }
    public static class Builder {

        private int id;
        private String name;
        private List <Vote> votes;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setVotes(List <Vote> votes) {
            this.votes = votes;
            return this;
        }

        public Builder copy(Choice choice) {
            this.id = choice.id;
            this.name = choice.name;
            this.votes = choice.votes;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return id == builder.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        public Choice build() {
            return new Choice(this);
        }
    }
}
