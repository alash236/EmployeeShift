package com.example.EmployeeShift.vo.branch;

import com.example.EmployeeShift.entity.branch.Branch;

import java.util.List;

public class BranchRep {

    private int code;
    private String message;
    private Branch Branch;
    private List<Branch> Branchs;

    public BranchRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BranchRep(Branch branch, int code, String message) {
        this.Branch = branch;
        this.code = code;
        this.message = message;
    }

    public BranchRep(List<Branch> branchs, int code, String message) {
        this.Branchs = branchs;
        this.code = code;
        this.message = message;
    }

    public Branch getBranch() {
        return Branch;
    }

    public void setBranch(Branch branch) {
        Branch = branch;
    }

    public List<Branch> getBranchs() {
        return Branchs;
    }

    public void setBranchs(List<Branch> branchs) {
        Branchs = branchs;
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
