package com.example.EmployeeShift.service.branch.impl;

import com.example.EmployeeShift.dao.branch.BranchDao;
import com.example.EmployeeShift.entity.branch.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeShift.service.branch.ifs.BranchService;
import com.example.EmployeeShift.vo.branch.AddBranchRes;
import com.example.EmployeeShift.vo.branch.BranchRep;

import static com.example.EmployeeShift.constants.branch.BranchEnum.*;

@Service
public class BranchImpl implements BranchService {

    //日記
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BranchDao branchDao;

    @Override
    public BranchRep addBranch(AddBranchRes addBranchRes) throws Exception{
        try {
            branchDao.addBranch(
                    addBranchRes.getBranch_name(),
                    addBranchRes.getBranch_location(),
                    addBranchRes.getBranch_phone(),
                    addBranchRes.getBranch_email()
            );
            return new BranchRep(SUCCESS_ADD_BRANCH.getCode(),SUCCESS_ADD_BRANCH.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

    }

    @Override
    public BranchRep getBranchById(int branch_id) throws Exception{
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch == null){
                logger.error(NOT_FOUND_BRANCH.getMessage());
                return new BranchRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            if(branch.getBranch_name() == null || branch.getBranch_name().equals("")){
                return new BranchRep(BRANCH_NAME_SEARCH_NULL.getCode(), BRANCH_NAME_SEARCH_NULL.getMessage());
            }
            if(branch.getBranch_location() == null || branch.getBranch_location().equals("")){
                return new BranchRep(BRANCH_LOCATION_SEARCH_NULL.getCode(), BRANCH_LOCATION_SEARCH_NULL.getMessage());
            }
            if(branch.getBranch_phone() == null || branch.getBranch_phone().equals("")) {
                return new BranchRep(BRANCH_PHONE_SEARCH_NULL.getCode(), BRANCH_PHONE_SEARCH_NULL.getMessage());
            }
            if(branch.getBranch_email() == null || branch.getBranch_email().equals("")){
                return new BranchRep(BRANCH_EMAIL_SEARCH_NULL.getCode(), BRANCH_EMAIL_SEARCH_NULL.getMessage());
            }
            return new BranchRep(SUCCESS_SEARCH_BRANCH.getCode(),SUCCESS_SEARCH_BRANCH.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
