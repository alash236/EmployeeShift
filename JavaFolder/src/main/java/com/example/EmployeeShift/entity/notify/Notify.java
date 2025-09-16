package com.example.EmployeeShift.entity.notify;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notify")
public class Notify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int notify_id;

    @Column(name = "branch_id")
    private int branch_id;

    @Column(name = "text")
    private String notify_text;

    @Column(name = "notify_start_time")
    private LocalDate notify_startTime;

    @Column(name = "notify_end_time")
    private LocalDate notify_endTime;

    public LocalDate getNotify_endTime() {
        return notify_endTime;
    }

    public void setNotify_endTime(LocalDate notify_endTime) {
        this.notify_endTime = notify_endTime;
    }

    public int getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(int notify_id) {
        this.notify_id = notify_id;
    }

    public LocalDate getNotify_startTime() {
        return notify_startTime;
    }

    public void setNotify_startTime(LocalDate notify_startTime) {
        this.notify_startTime = notify_startTime;
    }

    public String getNotify_text() {
        return notify_text;
    }

    public void setNotify_text(String notify_text) {
        this.notify_text = notify_text;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
}
