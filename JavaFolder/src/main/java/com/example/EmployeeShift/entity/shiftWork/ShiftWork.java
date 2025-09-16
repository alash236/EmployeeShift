package com.example.EmployeeShift.entity.shiftWork;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Table(name = "shift_work")
@Entity
public class ShiftWork {
    @Id
    @Column(name = "shift_work_id")
    private int shift_work_id;

    @Column(name = "start_time")
    private LocalTime start_time;

    @Column(name = "end_time")
    private LocalTime end_time;

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public int getShift_work_id() {
        return shift_work_id;
    }

    public void setShift_work_id(int shift_work_id) {
        this.shift_work_id = shift_work_id;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }
}
