package com.example.EmployeeShift.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.stringtemplate.v4.ST;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_NAME_NULL;
import static com.example.EmployeeShift.constants.schedule.ScheduleMessage.WORK_DATE_NULL;
import static com.example.EmployeeShift.constants.shiftWork.ShiftWorkMessage.SHIFT_WORK_END_TIME_NULL;
import static com.example.EmployeeShift.constants.shiftWork.ShiftWorkMessage.SHIFT_WORK_START_TIME_NULL;

public class ShiftDto {

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String branch_employee_id;

    @NotBlank(message = BRANCH_EMPLOYEE_NAME_NULL)
    private String branch_employee_name;

    @NotNull(message = WORK_DATE_NULL)
    private LocalDate work_date;

    @NotNull(message = SHIFT_WORK_START_TIME_NULL)
    private LocalTime start_time;

    @NotNull(message = SHIFT_WORK_END_TIME_NULL)
    private LocalTime end_time;

    public ShiftDto(String branch_employee_id, String branch_employee_name, LocalDate work_date, LocalTime start_time, LocalTime end_time) {
        this.branch_employee_id = branch_employee_id;
        this.branch_employee_name = branch_employee_name;
        this.work_date = work_date;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getBranch_employee_id() {
        return branch_employee_id;
    }

    public void setBranch_employee_id(String branch_employee_id) {
        this.branch_employee_id = branch_employee_id;
    }

    public String getBranch_employee_name() {
        return branch_employee_name;
    }

    public void setBranch_employee_name(String branch_employee_name) {
        this.branch_employee_name = branch_employee_name;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalDate getWork_date() {
        return work_date;
    }

    public void setWork_date(LocalDate work_date) {
        this.work_date = work_date;
    }
}
