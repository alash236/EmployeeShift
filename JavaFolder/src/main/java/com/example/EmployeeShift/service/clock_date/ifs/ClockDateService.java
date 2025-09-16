package com.example.EmployeeShift.service.clock_date.ifs;

import com.example.EmployeeShift.vo.clock_date.AddClockDateRes;
import com.example.EmployeeShift.vo.clock_date.ClockDateRep;
import com.example.EmployeeShift.vo.clock_date.UpdateClockDateRes;
import com.example.EmployeeShift.vo.clock_date.UpdateClockOff;


public interface ClockDateService {

    public ClockDateRep addClockDate(AddClockDateRes addClockDateRes) throws Exception;

    public ClockDateRep updateClockDate(UpdateClockDateRes updateClockDateRes) throws Exception;

    public ClockDateRep updateClockOff(UpdateClockOff updateClockOff) throws Exception;

    public ClockDateRep getClockDateById(int branch_id,String employee_id);

    public ClockDateRep getAllClockDate(int branch_id);
}
