package com.example.EmployeeShift.controller.branch;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.EmployeeShift.service.branch.ifs.BranchService;
import com.example.EmployeeShift.vo.branch.AddBranchRes;
import com.example.EmployeeShift.vo.branch.BranchRep;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
public class BranchController {


    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    BranchService branchService;

    @GetMapping("/get/branch/{branch_id}")
    public BranchRep getBranchByID(@Min(value = 1,message = BRANCH_ID_MIN) @NotNull(message = BRANCH_ID_NULL) @PathVariable int branch_id) throws Exception{
        return branchService.getBranchById(branch_id);
    }

    @PostMapping("/add/branch")
    public BranchRep addBranch(@Valid @RequestBody AddBranchRes addBranchRes) throws Exception{
        return branchService.addBranch(addBranchRes);
    }
}
