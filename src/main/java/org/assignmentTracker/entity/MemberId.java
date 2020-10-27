package org.assignmentTracker.entity;

import java.io.Serializable;

public class MemberId implements Serializable {

    private String memberId , assignmentId ;

    public boolean equals (Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        MemberId that = (MemberId) obj;
        return memberId.equals(that.memberId) && assignmentId.equals(that.assignmentId) ;
    }

   /* public int hashCode (){
        return Object.hash(memberId , assignmentId);
    }*/
}
