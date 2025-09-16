package com.example.EmployeeShift.vo.clock_date;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;
import static com.example.EmployeeShift.constants.clock_date.ClockDateMessage.CLOCK_OFF_NULL;
import static com.example.EmployeeShift.constants.clock_date.ClockDateMessage.CLOCK_ON_NULL;

public class AddClockDateRes {

    @Min(value = 1,message = BRANCH_ID_MIN)
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String employee_id;

    @NotNull(message = CLOCK_ON_NULL)
    private LocalDateTime clock_on;


    public AddClockDateRes(int branch_id, String employee_id, LocalDateTime clock_on, LocalDateTime clock_off) {
        this.branch_id = branch_id;
        this.employee_id = employee_id;
        this.clock_on = clock_on;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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
}
