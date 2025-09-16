package com.example.EmployeeShift.vo.pre_schedule;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.*;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.SHIFT_WORK_ID_NULL;

public class UpdatePreScheduleRes {
    @Min(value = 1,message = BRANCH_ID_MIN)
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String branch_employee_id;

    @NotNull(message = APPLY_DATE_NULL)
    @Future(message = APPLY_DATE_TIME_BEFORE_TODAY)
    private LocalDate apply_date;

    private boolean is_working;

    @NotNull(message = SHIFT_WORK_ID_NULL)
    private int shift_work_id;

    @NotNull(message = IS_APPECT_NULL)
    private boolean is_accept;

    public UpdatePreScheduleRes(int branch_id, String branch_employee_id, LocalDate apply_date, boolean is_working, int shift_work_id, boolean is_accept) {
        this.branch_id = branch_id;
        this.branch_employee_id = branch_employee_id;
        this.apply_date = apply_date;
        this.is_working = is_working;
        this.shift_work_id = shift_work_id;
        this.is_accept = is_accept;
    }

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
        return branch_employee_id;
    }

    public void setEmployee_id(String branch_employee_id) {
        this.branch_employee_id = branch_employee_id;
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
