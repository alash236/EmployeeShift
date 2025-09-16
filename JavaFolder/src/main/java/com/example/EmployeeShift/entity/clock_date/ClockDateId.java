package com.example.EmployeeShift.entity.clock_date;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClockDateId implements Serializable {

    private int branch_id;
    private String employee_id;

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
}
