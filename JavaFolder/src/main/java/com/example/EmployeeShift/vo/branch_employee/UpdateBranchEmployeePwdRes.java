package com.example.EmployeeShift.vo.branch_employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.*;

public class UpdateBranchEmployeePwdRes {
    @Min(value=1 ,message = BRANCH_ID_MIN)
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String branch_employee_id;

    @NotBlank(message = BRANCH_EMPLOYEE_PWD_NULL)
    @Pattern(regexp = "^[A-Za-z0-9]{8,12}$",message = BRANCH_EMPLOYEE_PWD_FORMAT)
    private String branch_employee_pwd;

    public UpdateBranchEmployeePwdRes(String branch_employee_id, String branch_employee_pwd, int branch_id) {
        this.branch_employee_id = branch_employee_id;
        this.branch_employee_pwd = branch_employee_pwd;
        this.branch_id = branch_id;
    }

    public String getBranch_employee_id() {
        return branch_employee_id;
    }

    public void setBranch_employee_id(String branch_employee_id) {
        this.branch_employee_id = branch_employee_id;
    }

    public String getBranch_employee_pwd() {
        return branch_employee_pwd;
    }

    public void setBranch_employee_pwd(String branch_employee_pwd) {
        this.branch_employee_pwd = branch_employee_pwd;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
}
