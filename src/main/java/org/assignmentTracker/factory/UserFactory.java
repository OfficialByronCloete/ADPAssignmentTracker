package org.assignmentTracker.factory;

import org.assignmentTracker.entity.User;
import org.assignmentTracker.util.Helper;

import java.util.Date;

/*
@author Byron Cloete
StudNo: 214189872
Date: 29 June 2020
Desc: Test for User Factory
 */

public class UserFactory {

    public static User createUser(String name, String surname, String password, String email){
        int userID = Helper.generateID();
        long studNo = Helper.generateStudNum();
        Date date = new Date();
        User user = new User.Builder().
                setID(userID).
                setName(name).
                setSurname(surname).
                setStudNo(studNo).
                setPassword(password).
                setEmail(email).
                setJoinDate(date).
                build();
        return user;
    }

}
