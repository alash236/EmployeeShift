package com.example.EmployeeShift.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.*;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.*;


public class ScheduleDto {

    @Min(value = 1,message = BRANCH_ID_MIN)
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String employee_id;

    @NotBlank(message = BRANCH_EMPLOYEE_STATE_NULL)
    private String branch_employee_state;

    @NotNull(message = APPLY_DATE_NULL)
    private LocalDate apply_date;

    @NotNull(message = IS_WORKING_NULL)
    private boolean is_working;

    @Min(value = 1,message = SHIFT_WORK_ID_MIN)
    @NotNull(message = SHIFT_WORK_ID_NULL)
    private int shift_work_id;

    @NotNull(message = IS_APPECT_NULL)
    private boolean is_accept;

    public ScheduleDto(int branch_id, String employee_id, int shift_work_id, String branch_employee_state, LocalDate apply_date, boolean is_working,boolean is_accept) {
        this.branch_id = branch_id;
        this.employee_id = employee_id;
        this.shift_work_id = shift_work_id;
        this.branch_employee_state = branch_employee_state;
        this.apply_date = apply_date;
        this.is_working = is_working;
        this.is_accept = is_accept;
    }

    public LocalDate getApply_date() {
        return apply_date;
    }

    public void setApply_date(LocalDate apply_date) {
        this.apply_date = apply_date;
    }

    public String getBranch_employee_state() {
        return branch_employee_state;
    }

    public void setBranch_employee_state(String branch_employee_state) {
        this.branch_employee_state = branch_employee_state;
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
