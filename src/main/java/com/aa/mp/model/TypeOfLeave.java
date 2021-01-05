package com.aa.mp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types_of_leaves")
public class TypeOfLeave {

    @Id
    private String leaveType;

    public TypeOfLeave() {
        //this.leaveType = leaveType;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @Override
    public String toString() {
        return "TypeOfLeave{" +
                "leaveType='" + leaveType + '\'' +
                '}';
    }
}
