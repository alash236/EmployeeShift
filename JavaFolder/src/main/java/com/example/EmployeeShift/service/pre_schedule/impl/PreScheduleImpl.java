package com.example.EmployeeShift.service.pre_schedule.impl;

import com.example.EmployeeShift.constants.preSchedule.PreScheduleEnum;
import com.example.EmployeeShift.dao.branch.BranchDao;
import com.example.EmployeeShift.dao.branch_employee.BranchEmployeeDao;
import com.example.EmployeeShift.dao.pre_schedule.PreScheduleDao;
import com.example.EmployeeShift.entity.branch.Branch;
import com.example.EmployeeShift.entity.branch_employee.BranchEmployee;
import com.example.EmployeeShift.entity.pre_schedule.PreSchedule;
import com.example.EmployeeShift.service.pre_schedule.ifs.PreScheduleService;
import com.example.EmployeeShift.vo.AddPreScheduleListRes;
import com.example.EmployeeShift.vo.pre_schedule.AddPreScheduleRes;
import com.example.EmployeeShift.vo.pre_schedule.PreScheduleRep;
import com.example.EmployeeShift.vo.pre_schedule.ScheduleVo;
import com.example.EmployeeShift.vo.pre_schedule.UpdatePreScheduleRes;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.EmployeeShift.constants.branch.BranchEnum.NOT_FOUND_BRANCH;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeEnum.NOT_FOUND_EMPLOYEE;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeEnum.NOT_FOUND_EMPLOYEE_LIST;
import static com.example.EmployeeShift.constants.preSchedule.PreScheduleEnum.*;

@Service
public class PreScheduleImpl implements PreScheduleService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BranchDao branchDao;

    @Autowired
    BranchEmployeeDao branchEmployeeDao;

    @Autowired
    PreScheduleDao preScheduleDao;

    @Override
    public PreScheduleRep addPreScheduleList(AddPreScheduleListRes addPreScheduleListRes) {
        try {
            Branch branch = branchDao.getBranchById(addPreScheduleListRes.getBranch_id());
            if(branch==null){
                return new PreScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }

            //先查詢該員工是否存在
            BranchEmployee employee = branchEmployeeDao.getBranchEmployeeById(
                    addPreScheduleListRes.getBranch_id(),
                    addPreScheduleListRes.getEmployee_id());
            PreScheduleRep preScheduleRep = validEmployee(employee);
            if(preScheduleRep!=null){
                return preScheduleRep;
            }
            PreSchedule preSchedule = preScheduleDao.getPreScheduleById(
                    addPreScheduleListRes.getBranch_id(),
                    addPreScheduleListRes.getEmployee_id());
            for(ScheduleVo scheduleVo:addPreScheduleListRes.getScheduleList()){
                if(preSchedule != null &&
                        preSchedule.getApply_date().equals(scheduleVo.getApply_date())){
                    return new PreScheduleRep(PRESCHEDULE_DUPLICATE.getCode(),
                            PRESCHEDULE_DUPLICATE.getMessage());
                }
                preScheduleDao.addPreSchedule(
                        addPreScheduleListRes.getBranch_id(),
                        addPreScheduleListRes.getEmployee_id(),
                        scheduleVo.getApply_date(),
                        scheduleVo.isIs_working(),
                        scheduleVo.getShift_work_id());
            }
            return new PreScheduleRep(PreScheduleEnum.SUCCESS_ADD_PRESCHEDULE.getCode(),
                    PreScheduleEnum.SUCCESS_ADD_PRESCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PreScheduleRep addPreSchedule(AddPreScheduleRes addPreScheduleRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(addPreScheduleRes.getBranch_id());
            if(branch==null){
                return new PreScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }

            //先查詢該員工是否存在
            BranchEmployee employee = branchEmployeeDao.getBranchEmployeeById(
                    addPreScheduleRes.getBranch_id(),
                    addPreScheduleRes.getEmployee_id());
            PreScheduleRep preScheduleRep = validEmployee(employee);
            if(preScheduleRep!=null){
                return preScheduleRep;
            }
            //判斷同一天是否有重複申請
            PreSchedule preSchedule = preScheduleDao.getPreScheduleById(
                    addPreScheduleRes.getBranch_id(),
                    addPreScheduleRes.getEmployee_id());
            if(preSchedule != null &&
                    preSchedule.getApply_date().equals(addPreScheduleRes.getApply_date())){
                return new PreScheduleRep(PRESCHEDULE_DUPLICATE.getCode(),
                        PRESCHEDULE_DUPLICATE.getMessage());
            }

            //新增預排班
            preScheduleDao.addPreSchedule(
                    addPreScheduleRes.getBranch_id(),
                    addPreScheduleRes.getEmployee_id(),
                    addPreScheduleRes.getApply_date(),
                    addPreScheduleRes.isIs_working(),
                    addPreScheduleRes.getShift_work_id());
            return new PreScheduleRep(PreScheduleEnum.SUCCESS_ADD_PRESCHEDULE.getCode(),
                    PreScheduleEnum.SUCCESS_ADD_PRESCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }


    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PreScheduleRep updatePreSchedule(UpdatePreScheduleRes updatePreScheduleRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(updatePreScheduleRes.getBranch_id());
            if(branch==null){
                return new PreScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }

            BranchEmployee employee = branchEmployeeDao.getBranchEmployeeById(
                    updatePreScheduleRes.getBranch_id(),
                    updatePreScheduleRes.getEmployee_id());
            //查詢該員工並驗證是否存在
            PreScheduleRep preScheduleRep = validEmployee(employee);

            PreSchedule preSchedule = preScheduleDao.getPreScheduleById(
                    updatePreScheduleRes.getBranch_id(),
                    updatePreScheduleRes.getEmployee_id());

            //查詢該預排班是否存在
            if(preSchedule == null){
                return new PreScheduleRep(NOT_FOUND_PRESCHEDULE.getCode(),
                        NOT_FOUND_PRESCHEDULE.getMessage());
            }

            preScheduleDao.updatePreSchedule(
                    updatePreScheduleRes.getBranch_id(),
                    updatePreScheduleRes.getEmployee_id(),
                    updatePreScheduleRes.getApply_date(),
                    updatePreScheduleRes.isIs_working(),
                    updatePreScheduleRes.getShift_work_id(),
                    updatePreScheduleRes.isIs_accept());
            return new PreScheduleRep(SUCCESS_UPDATE_PRESCHEDULE.getCode(),
                    SUCCESS_UPDATE_PRESCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PreScheduleRep deletePreSchedule(int branch_id, String employee_id) throws Exception {
       try {
           Branch branch = branchDao.getBranchById(branch_id);
           if(branch==null){
               return new PreScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
           }
           BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(branch_id,employee_id);
           if(branchEmployee == null){
               return new PreScheduleRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_EMPLOYEE.getMessage());
           }
           preScheduleDao.deletePreSchedule(branch_id,employee_id);
           return new PreScheduleRep(SUCCESS_DELETE_PRESCHEDULE.getCode(),
                   SUCCESS_DELETE_PRESCHEDULE.getMessage());
       } catch (Exception e) {
           logger.error(e.getMessage());
           throw e;
       }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PreScheduleRep getPreScheduleById(int branch_id, String employee_id) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new PreScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }

            //先查詢該員工是否存在
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(branch_id, employee_id);
            if(branchEmployee == null){
                return new PreScheduleRep(NOT_FOUND_EMPLOYEE.getCode(),NOT_FOUND_EMPLOYEE.getMessage());
            }
            //查詢該員工預排班是否存在
            PreSchedule preSchedule = preScheduleDao.getPreScheduleById(branch_id,employee_id);
            if(preSchedule == null){
                return new PreScheduleRep(NOT_FOUND_PRESCHEDULE.getCode(),
                        NOT_FOUND_PRESCHEDULE.getMessage());
            }
            //比對是否有預排班但沒有此員工情形
            if(branchEmployee == null && preSchedule != null){
                return new PreScheduleRep(EMPLOYEE_NOT_FOUND_PRESCHEDULE.getCode(),
                        EMPLOYEE_NOT_FOUND_PRESCHEDULE.getMessage());
            }
            return new PreScheduleRep(preSchedule,SUCCESS_SEARCH_PRESCHEDULE.getCode(),
                    SUCCESS_SEARCH_PRESCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public PreScheduleRep getAllPreSchedule(int branch_id, LocalDate apply_date) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new PreScheduleRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //先取得所有員工
            List<BranchEmployee> branchEmployeeList = branchEmployeeDao.getAllBranchEmployee(branch_id);
            if(branchEmployeeList == null){
                return new PreScheduleRep(NOT_FOUND_EMPLOYEE_LIST.getCode(), NOT_FOUND_EMPLOYEE_LIST.getMessage());
            }
            //取得所有預排班
            List<PreSchedule> preScheduleList = preScheduleDao.getAllPreSchedule(branch_id,apply_date,true);
            if(preScheduleList == null){
                return new PreScheduleRep(NOT_FOUND_PRESCHEDULE_LIST.getCode(),NOT_FOUND_PRESCHEDULE_LIST.getMessage());
            }
            //比對是否有預排班但沒有此員工情形
            for(BranchEmployee branchEmployee : branchEmployeeList){
                for(PreSchedule preSchedule : preScheduleList){
                    if(branchEmployee == null && preSchedule != null){
                        return new PreScheduleRep(EMPLOYEE_NOT_FOUND_PRESCHEDULE.getCode(),
                                EMPLOYEE_NOT_FOUND_PRESCHEDULE.getMessage());
                    }
                }
            }
            return new PreScheduleRep(preScheduleList,SUCCESS_SEARCH_PRESCHEDULE.getCode(),
                    SUCCESS_SEARCH_PRESCHEDULE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    private PreScheduleRep validEmployee(BranchEmployee branchEmployee) {
        if (branchEmployee == null) {
            return new PreScheduleRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_EMPLOYEE.getMessage());
        }
        //判斷是不是在職
        if (!branchEmployee.getBranch_employee_state().equals("在職")) {
            return new PreScheduleRep(EMPLOYEE_RESIGN.getCode(), EMPLOYEE_RESIGN.getMessage());
        }
        return  null;
    }
}
