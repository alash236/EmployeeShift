package com.example.EmployeeShift.service.branch_employee.ifs;

import com.example.EmployeeShift.vo.branch_employee.*;

public interface BranchEmployeeService {

    public BranchEmployeeRep addBranchEmployee(AddBranchEmployeeRes addBranchEmployeeRes) throws Exception;

    public BranchEmployeeRep updateBranchEmployee(UpdateBranchEmployeeRes updateBranchEmployeeRes) throws Exception;

    public BranchEmployeeRep deleteBranchEmployee(int branch_id,String branch_employee_id);

    public BranchEmployeeRep updateBranchEmployeePwd(UpdateBranchEmployeePwdRes updateBranchEmployeePwdRes) throws Exception;

    public BranchEmployeeRep loginBranchEmployee(LoginBranchEmployeeRes loginBranchEmployeeRes) throws Exception;

    public BranchEmployeeRep getBranchEmployeeById(int branch_id,String branch_employee_id) throws Exception;

    public BranchEmployeeRep getAllBranchEmployee(int branch_id) throws Exception;
}
