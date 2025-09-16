package com.example.EmployeeShift.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_NAME_NULL;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.SHIFT_WORK_ID_MIN;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.SHIFT_WORK_ID_NULL;
import static com.example.EmployeeShift.constants.schedule.ScheduleMessage.WORK_DATE_NULL;

public class PreScheduleDto {

    @NotBlank(message = BRANCH_EMPLOYEE_NAME_NULL)
    private String branch_employee_name;

    @NotNull(message = WORK_DATE_NULL)
    private LocalDate apply_date;

    @Min(value = 1,message = SHIFT_WORK_ID_MIN)
    @NotNull(message = SHIFT_WORK_ID_NULL)
    private int shift_work_id;

    public PreScheduleDto(String branch_employee_name, LocalDate apply_date, int shift_work_id) {
        this.branch_employee_name = branch_employee_name;
        this.apply_date = apply_date;
        this.shift_work_id = shift_work_id;
    }

    public LocalDate getApply_date() {
        return apply_date;
    }

    public void setApply_date(LocalDate apply_date) {
        this.apply_date = apply_date;
    }

    public String getBranch_employee_name() {
        return branch_employee_name;
    }

    public void setBranch_employee_name(String branch_employee_name) {
        this.branch_employee_name = branch_employee_name;
    }

    public int getShift_work_id() {
        return shift_work_id;
    }

    public void setShift_work_id(int shift_work_id) {
        this.shift_work_id = shift_work_id;
    }
}
