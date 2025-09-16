package com.example.EmployeeShift.entity.pre_schedule;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "pre_schedule")
@IdClass(PreScheduleId.class)
public class PreSchedule {
    @Id
    @Column(name = "branch_id")
    private int branch_id;

    @Id
    @Column(name = "employee_id")
    private String employee_id;

    @Id
    @Column(name = "apply_date")
    private LocalDate apply_date;

    @Column(name = "is_working")
    private boolean is_working;

    @Column(name = "shift_work_id")
    private int shift_work_id;

    @Column(name = "is_accept")
    private boolean is_accept;

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

    public boolean isIs_working() {
        return is_working;
    }

    public void setIs_working(boolean is_working) {
        this.is_working = is_working;
    }

    public int getShift_work_id() {
        return shift_work_id;
    }

    public void setShift_work_id(int shift_work_id) {
        this.shift_work_id = shift_work_id;
    }

    public boolean isIs_accept() {
        return is_accept;
    }

    public void setIs_accept(boolean is_accept) {
        this.is_accept = is_accept;
    }
}
