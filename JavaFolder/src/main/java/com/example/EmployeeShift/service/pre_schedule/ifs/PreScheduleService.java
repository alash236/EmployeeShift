package com.example.EmployeeShift.service.pre_schedule.ifs;

import com.example.EmployeeShift.vo.AddPreScheduleListRes;
import com.example.EmployeeShift.vo.pre_schedule.AddPreScheduleRes;
import com.example.EmployeeShift.vo.pre_schedule.PreScheduleRep;
import com.example.EmployeeShift.vo.pre_schedule.UpdatePreScheduleRes;

import java.time.LocalDate;

public interface PreScheduleService {
    public PreScheduleRep addPreSchedule(AddPreScheduleRes addPreScheduleRes) throws Exception;

    public PreScheduleRep addPreScheduleList(AddPreScheduleListRes addPreScheduleListRes);

    public PreScheduleRep updatePreSchedule(UpdatePreScheduleRes updatePreScheduleRes) throws Exception;

    public PreScheduleRep deletePreSchedule(int branch_id, String employee_id) throws Exception;

    public PreScheduleRep getPreScheduleById(int branch_id, String employee_id) throws Exception;

    public PreScheduleRep getAllPreSchedule(int branch_id, LocalDate apply_date) throws Exception;

}
