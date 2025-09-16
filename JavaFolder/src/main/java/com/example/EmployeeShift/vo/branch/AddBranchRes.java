package com.example.EmployeeShift.vo.branch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import static com.example.EmployeeShift.constants.branch.BranchMessage.*;

public class AddBranchRes {

    @NotBlank(message = BRANCH_NAME_NULL)
    private String branch_name;
    @NotBlank(message = BRANCH_LOCATION_NULL)
    private String branch_location;
    @NotBlank(message = BRANCH_PHONE_NULL)
    @Pattern(regexp = "^0\\d{1,2}-?\\d{6,8}$", message = BRANCH_PHONE_FORMAT_ERROR)
    private String branch_phone;
    @NotBlank(message = BRANCH_EMAIL_NULL)
    @Pattern(regexp = "^[\\\\w.-]+@[\\\\w.-]+\\\\.[a-zA-Z]{2,6}$",message = BRANCH_EMAIL_FORMAT_ERROR)
    private String branch_email;

    public AddBranchRes(String branch_email, String branch_location, String branch_name, String branch_phone) {
        this.branch_email = branch_email;
        this.branch_location = branch_location;
        this.branch_name = branch_name;
        this.branch_phone = branch_phone;
    }

    public String getBranch_email() {
        return branch_email;
    }

    public void setBranch_email(String branch_email) {
        this.branch_email = branch_email;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public void setBranch_location(String branch_location) {
        this.branch_location = branch_location;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_phone() {
        return branch_phone;
    }

    public void setBranch_phone(String branch_phone) {
        this.branch_phone = branch_phone;
    }
}
