package com.example.EmployeeShift.entity.branch;


import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int branch_id;

    @Column(name = "branch_name")
    private String branch_name;

    @Column(name = "branch_location")
    private String branch_location;

    @Column(name = "branch_phone")
    private String branch_phone;

    @Column(name = "branch_email")
    private String branch_email;

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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

    public String getBranch_email() {
        return branch_email;
    }

    public void setBranch_email(String branch_email) {
        this.branch_email = branch_email;
    }
}
