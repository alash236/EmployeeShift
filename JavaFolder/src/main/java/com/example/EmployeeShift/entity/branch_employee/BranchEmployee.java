package com.example.EmployeeShift.entity.branch_employee;

import jakarta.persistence.*;

@Entity
@Table(name="branch_employee")
@IdClass(BranchEmployeeId.class)
public class BranchEmployee {

    @Id
    @Column(name = "branch_id")
    private int branch_id;

    @Id
    @Column(name = "id")
    private String branch_employee_id;

    @Column(name = "name")
    private String branch_employee_name;

    @Column(name = "status")
    private String branch_employee_state;

    @Column(name = "email")
    private String branch_employee_email;

    @Column(name = "phone")
    private String branch_employee_phone;

    @Column(name = "title")
    private String branch_employee_title;

    @Column(name = "pwd")
    private String branch_employee_pwd;


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

    public String getBranch_employee_pwd() {
        return branch_employee_pwd;
    }

    public void setBranch_employee_pwd(String branch_employee_pwd) {
        this.branch_employee_pwd = branch_employee_pwd;
    }
}
