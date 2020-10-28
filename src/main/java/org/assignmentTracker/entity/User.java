package org.assignmentTracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
/*
@author Byron Cloete
StudNo: 214189872
Date: 29 June 2020
Desc: Base User class using builder
 */

@Entity
public class User {

    @Id
    private int id;
    private String name;
    private String surname;
    private long studNo;
    private String password;
    private String email;
    private Date joinDate;

    protected User() {}

    public User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.studNo = builder.studNo;
        this.password = builder.password;
        this.email = builder.email;
        this.joinDate = builder.joinDate;

    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public long getStudNo(){
        return studNo;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public Date getJoinDate(){
        return joinDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studNo=" + studNo +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }

    public static class Builder {
        private String name, surname, password, email;
        private int id;
        private long studNo;
        private Date joinDate;

        public Builder setID(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder setStudNo(long studNo){
            this.studNo = studNo;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setJoinDate(Date joinDate){
            this.joinDate = joinDate;
            return this;
        }

        public User build(){return new User(this);}

        public User.Builder copy(User user) {
            this.id = user.id;
            this.name = user.name;
            this.surname = user.surname;
            this.studNo = user.studNo;
            this.password = user.password;
            this.email = user.email;
            this.joinDate = user.joinDate;
            return this;
        }

    }

}
