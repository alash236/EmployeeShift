package com.example.EmployeeShift.service.branch.ifs;

import com.example.EmployeeShift.vo.branch.AddBranchRes;
import com.example.EmployeeShift.vo.branch.BranchRep;

public interface BranchService {

    public BranchRep addBranch(AddBranchRes addBranchRes) throws Exception;

    public BranchRep getBranchById(int branch_id) throws Exception;
}
