package com.example.EmployeeShift.vo;

import com.example.EmployeeShift.vo.pre_schedule.ScheduleVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.PRESCHEDULE_LIST_NULL;

public class AddPreScheduleListRes {

    @Min(value = 1 ,message = BRANCH_ID_MIN)
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String employee_id;

    @Valid
    @NotEmpty(message = PRESCHEDULE_LIST_NULL)
    List<ScheduleVo> scheduleList;

    public AddPreScheduleListRes(int branch_id, String employee_id, List<ScheduleVo> scheduleList) {
        this.branch_id = branch_id;
        this.employee_id = employee_id;
        this.scheduleList = scheduleList;
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

    public List<ScheduleVo> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<ScheduleVo> scheduleList) {
        this.scheduleList = scheduleList;
    }
}

