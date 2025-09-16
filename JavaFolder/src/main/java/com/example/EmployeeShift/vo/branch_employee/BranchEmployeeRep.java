package com.example.EmployeeShift.vo.branch_employee;

import com.example.EmployeeShift.entity.branch_employee.BranchEmployee;

import java.util.List;

public class BranchEmployeeRep {
    private int code;
    private String message;
    private BranchEmployee BranchEmployee;
    private List<BranchEmployee> BranchEmployees;

    public BranchEmployeeRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BranchEmployeeRep(List<BranchEmployee> branchEmployees, int code, String message) {
        this.BranchEmployees = branchEmployees;
        this.code = code;
        this.message = message;
    }

    public BranchEmployeeRep(BranchEmployee branchEmployee,int code, String message) {
        this.BranchEmployee = branchEmployee;
        this.code = code;
        this.message = message;
    }

    public BranchEmployee getBranchEmployee() {
        return BranchEmployee;
    }

    public void setBranchEmployee(BranchEmployee branchEmployee) {
        BranchEmployee = branchEmployee;
    }

    public List<BranchEmployee> getBranchEmployees() {
        return BranchEmployees;
    }

    public void setBranchEmployees(List<BranchEmployee> branchEmployees) {
        BranchEmployees = branchEmployees;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
