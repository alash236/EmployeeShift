package com.example.EmployeeShift.service.branch_employee.impl;

import com.example.EmployeeShift.dao.branch.BranchDao;
import com.example.EmployeeShift.dao.branch_employee.BranchEmployeeDao;
import com.example.EmployeeShift.entity.branch.Branch;
import com.example.EmployeeShift.entity.branch_employee.BranchEmployee;
import com.example.EmployeeShift.vo.branch_employee.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EmployeeShift.service.branch_employee.ifs.BranchEmployeeService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.EmployeeShift.constants.branch.BranchEnum.BRANCH_ID_ZERO;
import static com.example.EmployeeShift.constants.branch.BranchEnum.NOT_FOUND_BRANCH;
import static com.example.EmployeeShift.constants.branchEmployee.BranchEmployeeEnum.*;

@Service
public class BranchEmployeeImpl implements BranchEmployeeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    BranchDao branchDao;

    @Autowired
    BranchEmployeeDao branchEmployeeDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep addBranchEmployee(AddBranchEmployeeRes addBranchEmployeeRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(addBranchEmployeeRes.getBranch_id());
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //檢查該員工是否已經存在
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(addBranchEmployeeRes.getBranch_id(), addBranchEmployeeRes.getBranch_employee_id());
            if(branchEmployee != null){
                return new BranchEmployeeRep(BRANCH_EMPLOYEE_EXIST.getCode(),BRANCH_EMPLOYEE_EXIST.getMessage());
            }

            //對比全公司員工的手機跟信箱查看是否重複
            BranchEmployeeRep branchEmployeeRep = validEmployee(
                    addBranchEmployeeRes.getBranch_id(),
                    addBranchEmployeeRes.getBranch_employee_id(),
                    addBranchEmployeeRes.getBranch_employee_email(),
                    addBranchEmployeeRes.getBranch_employee_phone());
            if(branchEmployeeRep!=null){
                return branchEmployeeRep;
            }

            //新增員工
            branchEmployeeDao.addBranchEmployee(addBranchEmployeeRes.getBranch_id(),
                    addBranchEmployeeRes.getBranch_employee_id(),
                    addBranchEmployeeRes.getBranch_employee_name(),
                    addBranchEmployeeRes.getBranch_employee_state(),
                    addBranchEmployeeRes.getBranch_employee_email(),
                    addBranchEmployeeRes.getBranch_employee_phone(),
                    addBranchEmployeeRes.getBranch_employee_title());
            return new BranchEmployeeRep(SUCCESS_ADD_EMPLOYEE.getCode(),SUCCESS_ADD_EMPLOYEE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep updateBranchEmployee(UpdateBranchEmployeeRes updateBranchEmployeeRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(updateBranchEmployeeRes.getBranch_id());
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //查詢員工是否存在與對比全公司員工的手機跟信箱查看是否重複
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(
                    updateBranchEmployeeRes.getBranch_id(),
                    updateBranchEmployeeRes.getBranch_employee_id());
            if(branchEmployee == null){
                return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE.getCode(),NOT_FOUND_EMPLOYEE.getMessage());
            }
            BranchEmployeeRep branchEmployeeRep = validEmployee(
                    updateBranchEmployeeRes.getBranch_id(),
                    updateBranchEmployeeRes.getBranch_employee_id(),
                    updateBranchEmployeeRes.getBranch_employee_email(),
                    updateBranchEmployeeRes.getBranch_employee_phone());
            if(branchEmployeeRep!=null){
                return branchEmployeeRep;
            }

            //更新員工
            branchEmployeeDao.updateBranchEmployee(
                    updateBranchEmployeeRes.getBranch_id(),
                    updateBranchEmployeeRes.getBranch_employee_id(),
                    updateBranchEmployeeRes.getBranch_employee_name(),
                    updateBranchEmployeeRes.getBranch_employee_state(),
                    updateBranchEmployeeRes.getBranch_employee_email(),
                    updateBranchEmployeeRes.getBranch_employee_phone(),
                    updateBranchEmployeeRes.getBranch_employee_title());
            return new BranchEmployeeRep(SUCCESS_UPDATE_EMPLOYEE.getCode(), SUCCESS_UPDATE_EMPLOYEE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep deleteBranchEmployee(int branch_id,String branch_employee_id) {
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //查詢該員工是否存在
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(branch_id, branch_employee_id);
            if(branchEmployee == null){
                return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_EMPLOYEE.getMessage());
            }

            //刪除員工
            branchEmployeeDao.deleteBranchEmployee(branch_id,branch_employee_id);
            return new BranchEmployeeRep(SUCCESS_DELETE_EMPLOYEE.getCode(), SUCCESS_DELETE_EMPLOYEE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep updateBranchEmployeePwd(UpdateBranchEmployeePwdRes updateBranchEmployeePwdRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(updateBranchEmployeePwdRes.getBranch_id());
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //查詢該員工是否存在
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(updateBranchEmployeePwdRes.getBranch_id(), updateBranchEmployeePwdRes.getBranch_employee_id());
            if(branchEmployee==null){
                return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE.getCode(),
                        NOT_FOUND_EMPLOYEE.getMessage());
            }

            //加密密碼
            String pwd = encoder.encode(updateBranchEmployeePwdRes.getBranch_employee_pwd());

            //更新密碼
            branchEmployeeDao.updateBranchEmployeePwd(
                    updateBranchEmployeePwdRes.getBranch_id(),
                    updateBranchEmployeePwdRes.getBranch_employee_id(),
                    pwd);
            return new BranchEmployeeRep(SUCCESS_UPDATE_EMPLOYEE_PWD.getCode(),SUCCESS_UPDATE_EMPLOYEE_PWD.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep loginBranchEmployee(LoginBranchEmployeeRes loginBranchEmployeeRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(loginBranchEmployeeRes.getBranch_id());
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //查詢該員工是否存在
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(
                    loginBranchEmployeeRes.getBranch_id(),
                    loginBranchEmployeeRes.getBranch_employee_id());
            if(branchEmployee == null){
                return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_EMPLOYEE.getMessage());
            }

            //比對密碼是否正確
            if(!encoder.matches(loginBranchEmployeeRes.getBranch_employee_pwd(),branchEmployee.getBranch_employee_pwd())){
                return new BranchEmployeeRep(PASSWORD_MISMATCH.getCode(), PASSWORD_MISMATCH.getMessage());
            }
            return new BranchEmployeeRep(SUCCESS_LOGIN.getCode(), SUCCESS_LOGIN.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep getBranchEmployeeById(int branch_id, String branch_employee_id) throws Exception{
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //查詢該員工是否存在與比對資訊
            BranchEmployee branchEmployee = branchEmployeeDao.getBranchEmployeeById(branch_id,branch_employee_id);
            BranchEmployeeRep response = validBranch(branchEmployee);
            if(response!=null){
                return response;
            }
            return new BranchEmployeeRep(branchEmployee,SUCCESS_SEARCH_EMPLOYEE.getCode(),SUCCESS_SEARCH_EMPLOYEE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchEmployeeRep getAllBranchEmployee(int branch_id) throws Exception{
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new BranchEmployeeRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //查詢該分布員工是否存在
            List<BranchEmployee> employeeList = branchEmployeeDao.getAllBranchEmployee(branch_id);
            if(employeeList==null){
                return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE_LIST.getCode(),NOT_FOUND_EMPLOYEE_LIST.getMessage());
            }

            //查詢該員工是否存在與比對資訊
            for(BranchEmployee employee:employeeList){
                BranchEmployeeRep response = validBranch(employee);
                if(response!=null){
                    return response;
                }
            }
            return new BranchEmployeeRep(employeeList,SUCCESS_SEARCH_EMPLOYEE.getCode(),SUCCESS_SEARCH_EMPLOYEE.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /***
     * 先取全部員工INFO跑for去比
     * 對比全公司員工的手機跟信箱查看是否重複
     */
    private BranchEmployeeRep validEmployee(int branch_id,String employee_id,String email,String phone){
        List<BranchEmployee> branchEmployeeList = branchEmployeeDao.getAllBranchEmployee(branch_id);
        if(branchEmployeeList == null){
            return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE_LIST.getCode(),NOT_FOUND_EMPLOYEE_LIST.getMessage());
        }
        for(BranchEmployee employee:branchEmployeeList){
            if(employee!=null && employee.getBranch_employee_id().equals(employee_id)){
                continue;
            }
            if(employee!=null && employee.getBranch_employee_email().equals(email)){
                return new BranchEmployeeRep(BRANCH_EMPLOYEE_EMAIL_EXIST.getCode(),
                        BRANCH_EMPLOYEE_EMAIL_EXIST.getMessage());
            }
            if(employee!=null && employee.getBranch_employee_phone().equals(phone)){
                return new BranchEmployeeRep(BRANCH_EMPLOYEE_PHONE_EXIST.getCode(),
                        BRANCH_EMPLOYEE_PHONE_EXIST.getMessage());
            }
        }
        return null;
    }

    /***
     * 取員工INFO
     * 店家ID不能比0小
     * 對比員工的INFO是否是空值或是該員工是否存在
     */
    private BranchEmployeeRep validBranch(BranchEmployee branchEmployee){
        if(branchEmployee == null){
            return new BranchEmployeeRep(NOT_FOUND_EMPLOYEE.getCode(), NOT_FOUND_EMPLOYEE.getMessage());
        }
        if(branchEmployee.getBranch_id() <= 0){
            return new BranchEmployeeRep(BRANCH_ID_ZERO.getCode(), BRANCH_ID_ZERO.getMessage());
        }
        if(branchEmployee.getBranch_employee_id() == null || branchEmployee.getBranch_employee_id().equals("")){
            return new BranchEmployeeRep(BRANCH_EMPLOYEE_ID_NULL.getCode(), BRANCH_EMPLOYEE_ID_NULL.getMessage());
        }
        if(branchEmployee.getBranch_employee_name() == null || branchEmployee.getBranch_employee_name().equals("")){
            return new BranchEmployeeRep(BRANCH_EMPLOYEE_NAME_NULL.getCode(), BRANCH_EMPLOYEE_NAME_NULL.getMessage());
        }
        if(branchEmployee.getBranch_employee_state() == null || branchEmployee.getBranch_employee_state().equals("")){
            return new BranchEmployeeRep(BRANCH_EMPLOYEE_STATE_NULL.getCode(), BRANCH_EMPLOYEE_STATE_NULL.getMessage());
        }
        if(branchEmployee.getBranch_employee_email() == null || branchEmployee.getBranch_employee_email().equals("")){
            return new BranchEmployeeRep(BRANCH_EMPLOYEE_EMAIL_NULL.getCode(), BRANCH_EMPLOYEE_EMAIL_NULL.getMessage());
        }
        if(branchEmployee.getBranch_employee_phone() == null || branchEmployee.getBranch_employee_phone().equals("")){
            return new BranchEmployeeRep(BRANCH_EMPLOYEE_PHONE_NULL.getCode(), BRANCH_EMPLOYEE_PHONE_NULL.getMessage());
        }
        if(branchEmployee.getBranch_employee_title() == null || branchEmployee.getBranch_employee_title().equals("")){
            return new BranchEmployeeRep(BRANCH_EMPLOYEE_TITLE_NULL.getCode(), BRANCH_EMPLOYEE_TITLE_NULL.getMessage());
        }
        return null;
    }
}
