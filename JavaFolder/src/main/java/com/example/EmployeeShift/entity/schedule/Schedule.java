package com.example.EmployeeShift.entity.schedule;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "schedule")
@IdClass(ScheduleId.class)
public class Schedule {
    @Id
    @Column(name = "branch_id")
    private int branch_id;

    @Id
    @Column(name = "employee_id")
    private String employee_id;

    @Id
    @Column(name = "shift_work_id")
    private int shift_work_id;

    @Column(name = "work_date")
    private LocalDate work_date;

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

    public LocalDate getWork_date() {
        return work_date;
    }

    public void setWork_date(LocalDate work_date) {
        this.work_date = work_date;
    }
}
