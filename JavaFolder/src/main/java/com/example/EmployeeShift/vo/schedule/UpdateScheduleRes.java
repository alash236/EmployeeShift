package com.example.EmployeeShift.vo.schedule;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.SHIFT_WORK_ID_MIN;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.SHIFT_WORK_ID_NULL;
import static com.example.EmployeeShift.constants.schedule.ScheduleMessage.WORK_DATE_NULL;

public class UpdateScheduleRes {

    @Min(value = 1,message = BRANCH_ID_MIN)
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String employee_id;

    @Min(value = 1,message=SHIFT_WORK_ID_MIN)
    @NotNull(message = SHIFT_WORK_ID_NULL)
    private int shift_work_id;

    @NotNull(message = WORK_DATE_NULL)
    private LocalDate work_date;

    public UpdateScheduleRes(int branch_id, String employee_id, int shift_work_id, LocalDate work_date) {
        this.branch_id = branch_id;
        this.employee_id = employee_id;
        this.shift_work_id = shift_work_id;
        this.work_date = work_date;
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
