package com.example.EmployeeShift.controller.schedule;

import com.example.EmployeeShift.service.schedule.ifs.ScheduleService;
import com.example.EmployeeShift.vo.schedule.ScheduleRep;
import com.example.EmployeeShift.vo.schedule.UpdateScheduleRes;
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
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/getAll/shift/{branch_id}")
    public ScheduleRep getAllShift(@Min(value = 1,message = BRANCH_ID_MIN) @NotNull(message = BRANCH_ID_NULL)@PathVariable int branch_id) throws Exception{
        return scheduleService.getAllShift(branch_id);
    }

    @PostMapping("/add/shift/{branch_id}")
    public ScheduleRep addShift(
            @Min(value = 1,message = BRANCH_ID_MIN)
            @NotNull(message = BRANCH_ID_NULL)@PathVariable int branch_id)throws Exception{
        return scheduleService.addSchedule(branch_id);
    }

    @PutMapping("/update/shift")
    public ScheduleRep updateShift(@Valid @RequestBody UpdateScheduleRes updateScheduleRes) throws Exception{
        return scheduleService.updateSchedule(updateScheduleRes);
    }

    @DeleteMapping("/delete/shift/{branch_id}/{employee_id}")
    public ScheduleRep deleteShift(
            @Min(value = 1,message = BRANCH_ID_MIN)
            @NotNull(message = BRANCH_ID_NULL)@PathVariable int branch_id,
            @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)@PathVariable String employee_id) throws Exception{
                return scheduleService.deleteSchedule(branch_id,employee_id);
    }

}
