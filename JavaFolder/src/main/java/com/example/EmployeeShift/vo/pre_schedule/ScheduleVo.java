package com.example.EmployeeShift.vo.pre_schedule;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.*;

public class ScheduleVo {

    @NotNull(message = APPLY_DATE_NULL)
    private LocalDate apply_date;

    @NotNull(message = IS_WORKING_NULL)
    private boolean is_working;

    @Min(value = 1,message = SHIFT_WORK_ID_MIN)
    @NotNull(message = SHIFT_WORK_ID_NULL)
    private int shift_work_id;

    public ScheduleVo(LocalDate apply_date, boolean is_working, int shift_work_id) {
        this.apply_date = apply_date;
        this.is_working = is_working;
        this.shift_work_id = shift_work_id;
    }

    public LocalDate getApply_date() {
        return apply_date;
    }

    public void setApply_date(LocalDate apply_date) {
        this.apply_date = apply_date;
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
}
