package com.example.EmployeeShift.service.schedule.impl;

import com.example.EmployeeShift.dao.branch.BranchDao;
import com.example.EmployeeShift.dao.branch_employee.BranchEmployeeDao;
import com.example.EmployeeShift.dao.schedule.ScheduleDao;
import com.example.EmployeeShift.dto.ScheduleDto;
import com.example.EmployeeShift.dto.ShiftDto;
import com.example.EmployeeShift.entity.branch.Branch;
import com.example.EmployeeShift.entity.branch_employee.BranchEmployee;
import com.example.EmployeeShift.entity.schedule.Schedule;
import com.example.EmployeeShift.service.schedule.ifs.ScheduleService;
import com.example.EmployeeShift.vo.schedule.ScheduleRep;
import com.example.EmployeeShift.vo.schedule.UpdateScheduleRes;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.EmployeeShift.constants.branch.BranchEnum.NOT_FOUND_BRANCH;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeEnum.NOT_FOUND_EMPLOYEE;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeEnum.NOT_FOUND_EMPLOYEE_LIST;
import static com.example.EmployeeShift.constants.schedule.ScheduleEnum.*;

@Service
public class ScheduleImpl implements ScheduleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    BranchDao branchDao;

    @Autowired
    BranchEmployeeDao branchEmployeeDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ScheduleRep addSchedule(int branch_id) throws Exception {
        try {
            ScheduleRep scheduleRep = valid(branch_id);
            if(scheduleRep!=null){
                return scheduleRep;
            }
            List<ScheduleDto> scheduleDtoList = scheduleDao.getAllSchedule(branch_id);
            if(scheduleDtoList == null){
                return new ScheduleRep(NOT_FOUND_SCHEDULE_LIST.getCode(), NOT_FOUND_SCHEDULE_LIST.getMessage());
            }
            scheduleDao.deleteSchedule(branch_id);
            for(ScheduleDto scheduleDto:scheduleDtoList){
                if(scheduleDto == null){
                    return new ScheduleRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_SCHEDULE.getMessage());
                }
                if(!scheduleDto.isIs_working() || !scheduleDto.isIs_accept()){
                    continue;
                }
                if(!scheduleDto.getBranch_employee_state().equals("在職")){
                    return new ScheduleRep(EMPLOYEE_RESIGN.getCode(), EMPLOYEE_RESIGN.getMessage());
                }
                scheduleDao.addSchedule(
                        scheduleDto.getBranch_id(),
                        scheduleDto.getEmployee_id(),
                        scheduleDto.getShift_work_id(),
                        scheduleDto.getApply_date());
            }
            return new ScheduleRep(SUCCESS_ADD_SCHEDULE.getCode(), SUCCESS_ADD_SCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ScheduleRep updateSchedule(UpdateScheduleRes updateScheduleRes) throws Exception {
        try {
            ScheduleRep scheduleRep = valid(updateScheduleRes.getBranch_id());
            if(scheduleRep!=null){
                return scheduleRep;
            }
            Schedule schedule = scheduleDao.getScheduleById(
                    updateScheduleRes.getBranch_id(),
                    updateScheduleRes.getEmployee_id());
            if(schedule == null){
                return new ScheduleRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_SCHEDULE.getMessage());
            }
            scheduleDao.updateSchedule(
                    updateScheduleRes.getBranch_id(),
                    updateScheduleRes.getEmployee_id(),
                    updateScheduleRes.getShift_work_id(),
                    updateScheduleRes.getWork_date());
            return new ScheduleRep(SUCCESS_UPDATE_SCHEDULE.getCode(),SUCCESS_UPDATE_SCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ScheduleRep deleteSchedule(int branch_id, String employee_id) throws Exception {
        try {
            ScheduleRep scheduleRep = valid(branch_id);
            Schedule schedule = scheduleDao.getScheduleById(branch_id, employee_id);
            if(schedule == null){
                return new ScheduleRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_SCHEDULE.getMessage());
            }
            scheduleDao.deleteSchedule(branch_id,employee_id);
            return new ScheduleRep(SUCCESS_DELETE_SCHEDULE.getCode(),SUCCESS_DELETE_SCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ScheduleRep getAllShift(int branch_id) throws Exception{
        try {
            List<ShiftDto> scheduleDtoList = scheduleDao.getAllShift(branch_id);
            if(scheduleDtoList == null){
                return new ScheduleRep(NOT_FOUND_SCHEDULE_LIST.getCode(), NOT_FOUND_SCHEDULE_LIST.getMessage());
            }
            for(ShiftDto shiftDto:scheduleDtoList){
                if(shiftDto == null){
                    return new ScheduleRep(NOT_FOUND_SCHEDULE.getCode(), NOT_FOUND_SCHEDULE.getMessage());
                }
            }
            return new ScheduleRep(scheduleDtoList,SUCCESS_SEARCH_SCHEDULE.getCode(),SUCCESS_SEARCH_SCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    private ScheduleRep valid(int branch_id){
        Branch branch = branchDao.getBranchById(branch_id);
        if(branch == null){
            return new ScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
        }
        List<BranchEmployee> branchEmployeeList = branchEmployeeDao.getAllBranchEmployee(branch_id);
        if(branchEmployeeList == null){
            return new ScheduleRep(NOT_FOUND_EMPLOYEE_LIST.getCode(), NOT_FOUND_EMPLOYEE_LIST.getMessage());
        }
        for(BranchEmployee branchEmployee : branchEmployeeList){
            if(branchEmployee == null){
                return new ScheduleRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_EMPLOYEE.getMessage());
            }
        }
        return null;
    }
}
