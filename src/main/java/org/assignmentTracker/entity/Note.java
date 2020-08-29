package org.assignmentTracker.entity;

import java.util.Date;

public class Note {

    private int id;
    private String description,text;
    private  Date dateCreated;
    private User creator;


    private Note(Builder builder){
        this.id = builder.id;
        this.description = builder.description;
        this.text = builder.text;
        this.dateCreated = builder.dateCreated;
        this.creator = builder.creator;

    }// builder constructor

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public User getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", dateCreated=" + dateCreated +
                ", creator=" + creator +
                '}';
    }

    public static class Builder{

        private int id;
        private String description,text;
        private  Date dateCreated;
        private User creator;

        public Builder setId(int id){

            this.id= id ;
            return this;
        }

        public Builder setDescription(String description){

            this.description= description ;
            return this;
        }

        public Builder setText(String text){

            this.text= text ;
            return this;
        }

        public Builder setDateCreated(Date dateCreated){

            this.dateCreated= dateCreated ;
            return this;
        }

        public Builder setCreator(User creator){

            this.creator= creator ;
            return this;
        }

        public Note.Builder copy(Note note){

            this.id = note.id;
            this.description = note.description;
            this.text = note.text;
            this.dateCreated = note.dateCreated;
            this.creator = note.creator;
            return this;

        } // copy builder method


        public Note build(){
            return new Note(this);

        }//build method
    }// static builder
}