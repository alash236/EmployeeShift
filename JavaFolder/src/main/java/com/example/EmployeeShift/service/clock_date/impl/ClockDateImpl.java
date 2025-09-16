package com.example.EmployeeShift.service.clock_date.impl;

import com.example.EmployeeShift.dao.branch.BranchDao;
import com.example.EmployeeShift.dao.branch_employee.BranchEmployeeDao;
import com.example.EmployeeShift.dao.clock_date.ClockDateDao;
import com.example.EmployeeShift.dao.schedule.ScheduleDao;
import com.example.EmployeeShift.dao.shiftWork.ShiftWorkDao;
import com.example.EmployeeShift.entity.branch.Branch;
import com.example.EmployeeShift.entity.branch_employee.BranchEmployee;
import com.example.EmployeeShift.entity.clock_date.ClockDate;
import com.example.EmployeeShift.entity.schedule.Schedule;
import com.example.EmployeeShift.entity.shiftWork.ShiftWork;
import com.example.EmployeeShift.service.clock_date.ifs.ClockDateService;
import com.example.EmployeeShift.vo.clock_date.AddClockDateRes;
import com.example.EmployeeShift.vo.clock_date.ClockDateRep;
import com.example.EmployeeShift.vo.clock_date.UpdateClockDateRes;
import com.example.EmployeeShift.vo.clock_date.UpdateClockOff;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.EmployeeShift.constants.branch.BranchEnum.NOT_FOUND_BRANCH;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeEnum.NOT_FOUND_EMPLOYEE;
import static com.example.EmployeeShift.constants.clock_date.ClockDateEnum.*;
import static com.example.EmployeeShift.constants.schedule.ScheduleEnum.NOT_FOUND_SCHEDULE;

@Service
public class ClockDateImpl implements ClockDateService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BranchDao branchDao;

    @Autowired
    BranchEmployeeDao branchEmployeeDao;

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    ClockDateDao clockDateDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ClockDateRep addClockDate(AddClockDateRes addClockDateRes) throws Exception {
        try {
            ClockDateRep clockDateRep = validBranchAndEmployee(
                    addClockDateRes.getBranch_id(),
                    addClockDateRes.getEmployee_id());
            if(clockDateRep != null){
                return clockDateRep;
            }
            Schedule schedule = scheduleDao.getScheduleById(
                    addClockDateRes.getBranch_id(),
                    addClockDateRes.getEmployee_id()
            );
            if(schedule == null){
                return new ClockDateRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            if(!schedule.getWork_date().equals(addClockDateRes.getClock_on().toLocalDate())){
                return new ClockDateRep(CLOCK_DATE_ERROR.getCode(),CLOCK_DATE_ERROR.getMessage());
            }
            clockDateDao.addClockDate(
                    addClockDateRes.getBranch_id(),
                    addClockDateRes.getEmployee_id(),
                    addClockDateRes.getClock_on()
            );
            return new ClockDateRep(SUCCESS_ADD_CLOCK.getCode(), SUCCESS_ADD_CLOCK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ClockDateRep updateClockOff(UpdateClockOff updateClockOff) throws Exception {
        try {
            ClockDateRep clockDateRep = validBranchAndEmployee(
                    updateClockOff.getBranch_id(),
                    updateClockOff.getEmployee_id());
            if(clockDateRep != null){
                return clockDateRep;
            }
            Schedule schedule = scheduleDao.getScheduleById(
                    updateClockOff.getBranch_id(),
                    updateClockOff.getEmployee_id()
            );
            if(schedule == null){
                return new ClockDateRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            if(!schedule.getWork_date().equals(updateClockOff.getClock_off().toLocalDate())){
                return new ClockDateRep(CLOCK_DATE_ERROR.getCode(),CLOCK_DATE_ERROR.getMessage());
            }
            ClockDate clockDate = clockDateDao.getClockDateById(updateClockOff.getBranch_id(),updateClockOff.getEmployee_id());
            double hours = calculateWorkHours(clockDate.getClock_on(),updateClockOff.getClock_off());

            clockDateDao.updateClockDate(
                    updateClockOff.getBranch_id(),
                    updateClockOff.getEmployee_id(),
                    updateClockOff.getClock_off(),
                    hours,
                    updateClockOff.isCheck(),
                    updateClockOff.getScore()
            );
            return new ClockDateRep(SUCCESS_ADD_CLOCK.getCode(), SUCCESS_ADD_CLOCK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ClockDateRep updateClockDate(UpdateClockDateRes updateClockDateRes) throws Exception {
        try {
            ClockDateRep clockDateRep = validBranchAndEmployee(
                    updateClockDateRes.getBranch_id(),
                    updateClockDateRes.getEmployee_id());
            if(clockDateRep != null){
                return clockDateRep;
            }
            Schedule schedule = scheduleDao.getScheduleById(
                    updateClockDateRes.getBranch_id(),
                    updateClockDateRes.getEmployee_id()
            );
            if(schedule == null){
                return new ClockDateRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            if(!schedule.getWork_date().equals(updateClockDateRes.getClock_on().toLocalDate())){
                return new ClockDateRep(CLOCK_DATE_ERROR.getCode(),CLOCK_DATE_ERROR.getMessage());
            }
            if(!schedule.getWork_date().equals(updateClockDateRes.getClock_off().toLocalDate())){
                return new ClockDateRep(CLOCK_DATE_ERROR.getCode(),CLOCK_DATE_ERROR.getMessage());
            }
            double hours = calculateWorkHours(updateClockDateRes.getClock_on(),updateClockDateRes.getClock_off());

            clockDateDao.updateClockDate(
                    updateClockDateRes.getBranch_id(),
                    updateClockDateRes.getEmployee_id(),
                    updateClockDateRes.getClock_on(),
                    updateClockDateRes.getClock_off(),
                    hours,
                    updateClockDateRes.isCheck(),
                    updateClockDateRes.getScore()
            );
            return new ClockDateRep(SUCCESS_ADD_CLOCK.getCode(), SUCCESS_ADD_CLOCK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ClockDateRep getClockDateById(int branch_id, String employee_id) {
        try {
            ClockDate clockDate = clockDateDao.getClockDateById(branch_id,employee_id);
            if(clockDate == null){
                return new ClockDateRep(NOT_FOUND_CLOCK.getCode(), NOT_FOUND_CLOCK.getMessage());
            }
            return new ClockDateRep(clockDate,SUCCESS_SEAECH_CLOCK.getCode(),SUCCESS_SEAECH_CLOCK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ClockDateRep getAllClockDate(int branch_id) {
        try {
            List<ClockDate> clockDateList = clockDateDao.getAllClockDate(branch_id);
            if(clockDateList == null){
                return new ClockDateRep(NOT_FOUND_CLOCK_LIST.getCode(),NOT_FOUND_CLOCK_LIST.getMessage());
            }
            for(ClockDate clockDate:clockDateList){
                if(clockDate == null){
                    return new ClockDateRep(NOT_FOUND_CLOCK.getCode(), NOT_FOUND_CLOCK.getMessage());
                }
            }
            return new ClockDateRep(clockDateList,SUCCESS_SEAECH_CLOCK.getCode(),SUCCESS_SEAECH_CLOCK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    private ClockDateRep validBranchAndEmployee(int branch_id,String employee_id){
        Branch branch = branchDao.getBranchById(branch_id);
        if(branch == null){
            return new ClockDateRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
        }
        BranchEmployee  branchEmployee = branchEmployeeDao.getBranchEmployeeById(branch_id,employee_id);
        if(branchEmployee == null){
            return new ClockDateRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_BRANCH.getMessage());
        }
    return null;
    }

    private double calculateWorkHours(LocalDateTime start, LocalDateTime end){

        Duration duration = Duration.between(start, end);
        long totalMinutes = duration.toMinutes();
        long hours = totalMinutes / 60;        // 整數小時
        long minutes = totalMinutes % 60;      // 剩餘分鐘

        double result = hours;
        if (minutes >= 30) {
            result += 0.5; // 加半小時
        }
        return result;
    }
}
