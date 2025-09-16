package com.example.EmployeeShift.controller.clock_date;

import com.example.EmployeeShift.service.clock_date.ifs.ClockDateService;
import com.example.EmployeeShift.vo.clock_date.AddClockDateRes;
import com.example.EmployeeShift.vo.clock_date.ClockDateRep;
import com.example.EmployeeShift.vo.clock_date.UpdateClockDateRes;
import com.example.EmployeeShift.vo.clock_date.UpdateClockOff;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;

@CrossOrigin("http://localhost:4200")
@RestController
@Validated
public class ClockDateController {

    @Autowired
    ClockDateService clockDateService;

    @GetMapping("/get/clockDate/{branch_id}/{employee_id}")
    public ClockDateRep getClockDateById(@Min(value = 1,message = BRANCH_ID_MIN)@NotNull(message = BRANCH_ID_NULL) @PathVariable int branch_id,
                                         @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)@PathVariable String employee_id) throws Exception{
        return clockDateService.getClockDateById(branch_id,employee_id);
    }

    @GetMapping("/getAll/clockDate/{branch_id}")
    public ClockDateRep getAllClockDate(@Min(value = 1,message = BRANCH_ID_MIN)@NotNull(message = BRANCH_ID_NULL) @PathVariable int branch_id) throws Exception{
        return clockDateService.getAllClockDate(branch_id);
    }

    @PostMapping("/add/clockDate")
    public ClockDateRep addClockDate(@Valid @RequestBody AddClockDateRes addClockDateRes) throws Exception{
        return clockDateService.addClockDate(addClockDateRes);
    }

    @PutMapping("/update/clockDate")
    public ClockDateRep updateClockDate(@Valid @RequestBody UpdateClockDateRes updateClockDateRes) throws Exception{
        return clockDateService.updateClockDate(updateClockDateRes);
    }
    @PutMapping("/update/clockDateOff")
    public ClockDateRep updateClockDateOff(@Valid @RequestBody UpdateClockOff updateClockOff) throws Exception{
        return clockDateService.updateClockOff(updateClockOff);
    }
}
