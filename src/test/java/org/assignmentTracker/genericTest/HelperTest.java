package org.assignmentTracker.genericTest;

import org.assignmentTracker.util.Helper;
import org.junit.Assert;
import org.junit.Test;

public class HelperTest {

    @Test
    public void generateStudNumTest(){
        Helper helper = new Helper();
        System.out.println(helper.generateStudNum());
    }

    @Test
    public void generateUserID(){
        Helper helper = new Helper();
        System.out.println(helper.generateID());
    }

    @Test
    public void generateAssignmentId() {
        Assert.assertTrue(Helper.generateAssignmentId() > 0);
    }

    @Test
    public void generateVoteId() {
        Assert.assertTrue(Helper.generateVoteId() > 0);
    }

}
