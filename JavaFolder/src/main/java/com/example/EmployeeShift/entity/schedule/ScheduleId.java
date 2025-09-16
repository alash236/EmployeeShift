package com.example.EmployeeShift.entity.schedule;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ScheduleId implements Serializable {
    private int branch_id;
    private String employee_id;
    private int shift_work_id;

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getShift_work_id() {
        return shift_work_id;
    }

    public void setShift_work_id(int shift_work_id) {
        this.shift_work_id = shift_work_id;
    }
}
