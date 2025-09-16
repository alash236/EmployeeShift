package com.example.EmployeeShift.vo.branch_employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.*;

public class AddBranchEmployeeRes {
    @NotNull(message = BRANCH_ID_NULL)
    private int branch_id;

    @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)
    private String branch_employee_id;

    @NotBlank(message = BRANCH_EMPLOYEE_NAME_NULL)
    private String branch_employee_name;

    @NotBlank(message = BRANCH_EMPLOYEE_STATE_NULL)
    private String branch_employee_state;

    @NotBlank(message = BRANCH_EMPLOYEE_EMAIL_NULL)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = BRANCH_EMPLOYEE_EMAIL_FORMAT)
    private String branch_employee_email;

    @NotBlank(message = BRANCH_EMPLOYEE_PHONE_NULL)
    @Pattern(regexp = "^09\\d{8}$", message =BRANCH_EMPLOYEE_PHONE_FORMAT)
    private String branch_employee_phone;

    @NotBlank(message = BRANCH_EMPLOYEE_TITLE_NULL)
    private String branch_employee_title;

    public AddBranchEmployeeRes(String branch_employee_email, String branch_employee_id, String branch_employee_name, String branch_employee_phone, String branch_employee_state, String branch_employee_title, int branch_id) {
        this.branch_employee_email = branch_employee_email;
        this.branch_employee_id = branch_employee_id;
        this.branch_employee_name = branch_employee_name;
        this.branch_employee_phone = branch_employee_phone;
        this.branch_employee_state = branch_employee_state;
        this.branch_employee_title = branch_employee_title;
        this.branch_id = branch_id;
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

    public String getBranch_employee_phone() {
        return branch_employee_phone;
    }

    public void setBranch_employee_phone(String branch_employee_phone) {
        this.branch_employee_phone = branch_employee_phone;
    }

    public String getBranch_employee_title() {
        return branch_employee_title;
    }

    public void setBranch_employee_title(String branch_employee_title) {
        this.branch_employee_title = branch_employee_title;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_employee_email() {
        return branch_employee_email;
    }

    public void setBranch_employee_email(String branch_employee_email) {
        this.branch_employee_email = branch_employee_email;
    }

    public String getBranch_employee_state() {
        return branch_employee_state;
    }

    public void setBranch_employee_state(String branch_employee_state) {
        this.branch_employee_state = branch_employee_state;
    }
}
