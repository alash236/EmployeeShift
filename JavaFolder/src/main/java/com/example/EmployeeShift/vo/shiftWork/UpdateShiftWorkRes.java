package com.example.EmployeeShift.vo.shiftWork;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

import static com.example.EmployeeShift.constants.shiftWork.ShiftWorkMessage.*;

public class UpdateShiftWorkRes {

    @NotNull(message = SHIFT_WORK_ID_NULL)
    private int shift_work_id;

    private LocalTime start_time;

    private LocalTime end_time;

    public UpdateShiftWorkRes(int shift_work_id, LocalTime start_time,LocalTime end_time) {
        this.end_time = end_time;
        this.shift_work_id = shift_work_id;
        this.start_time = start_time;
    }

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
