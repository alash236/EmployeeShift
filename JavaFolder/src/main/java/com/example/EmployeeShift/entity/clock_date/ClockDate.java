package com.example.EmployeeShift.entity.clock_date;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clock_date")
@IdClass(ClockDateId.class)
public class ClockDate {

    @Id
    @Column(name = "branch_id")
    private int branch_id;

    @Id
    @Column(name = "employee_id")
    private String employee_id;

    @Column(name = "clock_on")
    private LocalDateTime clock_on;

    @Column(name = "clock_off")
    private LocalDateTime clock_off;

    @Column(name = "total_hours")
    private double total_hours;

    @Column(name = "check")
    private boolean check;

    @Column(name = "score")
    private int score;

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public LocalDateTime getClock_off() {
        return clock_off;
    }

    public void setClock_off(LocalDateTime clock_off) {
        this.clock_off = clock_off;
    }

    public LocalDateTime getClock_on() {
        return clock_on;
    }

    public void setClock_on(LocalDateTime clock_on) {
        this.clock_on = clock_on;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getTotal_hours() {
        return total_hours;
    }

    public void setTotal_hours(double total_hours) {
        this.total_hours = total_hours;
    }
}
