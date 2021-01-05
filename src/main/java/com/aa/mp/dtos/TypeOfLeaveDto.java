package com.aa.mp.dtos;

public class TypeOfLeaveDto {

    private String leaveType;

    public TypeOfLeaveDto() {
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
        return "TypeOfLeaveDto{" +
                "leaveType='" + leaveType + '\'' +
                '}';
    }
}
