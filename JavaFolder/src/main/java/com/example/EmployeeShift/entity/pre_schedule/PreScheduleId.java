package com.example.EmployeeShift.entity.pre_schedule;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class PreScheduleId implements Serializable {

    private int branch_id;
    private String employee_id;
    private LocalDate apply_date;

    public LocalDate getApply_date() {
        return apply_date;
    }

    public void setApply_date(LocalDate apply_date) {
        this.apply_date = apply_date;
    }

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
