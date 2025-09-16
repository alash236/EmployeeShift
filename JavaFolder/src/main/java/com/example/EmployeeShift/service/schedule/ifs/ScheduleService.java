package com.example.EmployeeShift.service.schedule.ifs;

import com.example.EmployeeShift.vo.schedule.ScheduleRep;
import com.example.EmployeeShift.vo.schedule.UpdateScheduleRes;

public interface ScheduleService {

    public ScheduleRep addSchedule(int branch_id) throws Exception;

    public ScheduleRep updateSchedule(UpdateScheduleRes updateScheduleRes) throws Exception;

    public ScheduleRep deleteSchedule(int branch_id,String employee_id) throws Exception;

    public ScheduleRep getAllShift(int branch_id) throws Exception;
}
