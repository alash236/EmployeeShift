package com.example.EmployeeShift.controller.pre_schedule;

import com.example.EmployeeShift.dao.pre_schedule.PreScheduleDao;
import com.example.EmployeeShift.service.pre_schedule.ifs.PreScheduleService;
import com.example.EmployeeShift.vo.AddPreScheduleListRes;
import com.example.EmployeeShift.vo.pre_schedule.AddPreScheduleRes;
import com.example.EmployeeShift.vo.pre_schedule.PreScheduleRep;
import com.example.EmployeeShift.vo.pre_schedule.UpdatePreScheduleRes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeMessage.BRANCH_EMPLOYEE_ID_NULL;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleMessage.APPLY_DATE_NULL;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
public class PreScheduleController {

    @Autowired
    PreScheduleService preScheduleService;

    @Autowired
    PreScheduleDao preScheduleDao;

    @GetMapping("/get/pre_schedule/{branch_id}/{employee_id}")
    public PreScheduleRep getPreScheduleById(@Min(value = 1,message = BRANCH_ID_MIN) @NotNull(message = BRANCH_ID_NULL)@PathVariable int branch_id,
                                             @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)@PathVariable String employee_id) throws Exception {
        return preScheduleService.getPreScheduleById(branch_id,employee_id);
    }

    @GetMapping("/getAll/pre_schedule/{branch_id}/{apply_date}")
    public PreScheduleRep getAllPreSchedule(@Min(value = 1,message = BRANCH_ID_MIN) @NotNull(message = BRANCH_ID_NULL)@PathVariable int branch_id,
                                            @NotNull(message = APPLY_DATE_NULL)@PathVariable LocalDate apply_date)throws Exception{
        return preScheduleService.getAllPreSchedule(branch_id,apply_date);
    }

    @PostMapping("/add/pre_schedule")
    public PreScheduleRep addPreSchedule(@Valid @RequestBody AddPreScheduleRes addPreScheduleRes) throws Exception{
        return preScheduleService.addPreSchedule(addPreScheduleRes);
    }

    @PostMapping("/add/pre_scheduleList")
    public PreScheduleRep addPreScheduleList(@Valid @RequestBody AddPreScheduleListRes addPreScheduleListRes) throws Exception{
        return preScheduleService.addPreScheduleList(addPreScheduleListRes);
    }

    @PutMapping("/update/pre_schedule")
    public PreScheduleRep updatePreSchedule(@Valid @RequestBody UpdatePreScheduleRes updatePreScheduleRes) throws Exception{
        return preScheduleService.updatePreSchedule(updatePreScheduleRes);
    }

    @DeleteMapping("/delete/pre_schedule/{branch_id}/{employee_id}")
    public PreScheduleRep deletePreSchedule(@Min(value = 1,message = BRANCH_ID_MIN) @NotNull(message = BRANCH_ID_NULL)@PathVariable int branch_id,
                                            @NotBlank(message = BRANCH_EMPLOYEE_ID_NULL)@PathVariable String employee_id) throws Exception {
        return preScheduleService.deletePreSchedule(branch_id,employee_id);
    }
}
