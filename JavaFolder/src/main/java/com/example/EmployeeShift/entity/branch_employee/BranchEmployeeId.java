package com.example.EmployeeShift.entity.branch_employee;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BranchEmployeeId implements Serializable {
    private int branch_id;
    private String branch_employee_id;

    public String getBranch_employee_id() {
        return branch_employee_id;
    }

    public void setBranch_employee_id(String branch_employee_id) {
        this.branch_employee_id = branch_employee_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
}
