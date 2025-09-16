package com.example.EmployeeShift.controller.branch_employee;

import com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage;
import com.example.EmployeeShift.vo.branch_employee.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.EmployeeShift.service.branch_employee.ifs.BranchEmployeeService;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
public class BranchEmployeeController {

    @Autowired
    BranchEmployeeService branchEmployeeService;

    @GetMapping("/get/branch_employee/{branch_id}/{branch_employee_id}")
    public BranchEmployeeRep getBranchEmployee(@Min(value=1 ,message = BRANCH_ID_MIN)@NotNull(message = BRANCH_ID_NULL) @PathVariable int branch_id,
                                               @NotBlank(message = BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL) @PathVariable String branch_employee_id) throws Exception {
        return branchEmployeeService.getBranchEmployeeById(branch_id,branch_employee_id);
    }

    @GetMapping("/getAll/branch_employee/{branch_id}")
    public BranchEmployeeRep getAllBranchEmployee(@Min(value=1 ,message = BRANCH_ID_MIN)@NotNull(message = BRANCH_ID_NULL) @PathVariable int branch_id) throws Exception {
        return branchEmployeeService.getAllBranchEmployee(branch_id);
    }

    @PostMapping("/login/branch_employee")
    public BranchEmployeeRep loginBranchEmployee(@Valid @RequestBody LoginBranchEmployeeRes loginBranchEmployeeRes) throws Exception {
        return branchEmployeeService.loginBranchEmployee(loginBranchEmployeeRes);
    }

    @PostMapping("/add/branch_employee")
    public BranchEmployeeRep addBranchEmployee(@Valid @RequestBody AddBranchEmployeeRes addBranchEmployeeRes) throws Exception{
        return branchEmployeeService.addBranchEmployee(addBranchEmployeeRes);
    }

    @PutMapping("/update/branch_employee")
    public BranchEmployeeRep updateBranchEmployee(@Valid @RequestBody UpdateBranchEmployeeRes updateBranchEmployeeRes) throws Exception {
        return branchEmployeeService.updateBranchEmployee(updateBranchEmployeeRes);
    }

    @PutMapping("/update/branchEmployeePwd")
    public BranchEmployeeRep updateBranchEmployeePwd(@Valid @RequestBody UpdateBranchEmployeePwdRes updateBranchEmployeePwdRes) throws Exception {
        return branchEmployeeService.updateBranchEmployeePwd(updateBranchEmployeePwdRes);
    }

    @DeleteMapping("/delete/branch_employee/{branch_id}/{branch_employee_id}")
    public BranchEmployeeRep deleteBranchEmployee( @Min(value=1 ,message = BRANCH_ID_MIN)@NotNull(message = BRANCH_ID_NULL) @PathVariable int branch_id,
                                                   @NotBlank(message = BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL) @PathVariable String branch_employee_id) throws Exception {
        return branchEmployeeService.deleteBranchEmployee(branch_id,branch_employee_id);
    }
}
