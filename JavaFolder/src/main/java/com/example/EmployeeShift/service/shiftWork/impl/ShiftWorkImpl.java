package com.example.EmployeeShift.service.shiftWork.impl;

import com.example.EmployeeShift.dao.shiftWork.ShiftWorkDao;
import com.example.EmployeeShift.entity.shiftWork.ShiftWork;
import com.example.EmployeeShift.service.shiftWork.ifs.ShiftWorkService;
import com.example.EmployeeShift.vo.shiftWork.AddShiftWorkRes;
import com.example.EmployeeShift.vo.shiftWork.ShiftWorkRep;
import com.example.EmployeeShift.vo.shiftWork.UpdateShiftWorkRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.EmployeeShift.constants.shiftWork.ShiftWorkEnum.*;

@Service
public class ShiftWorkImpl implements ShiftWorkService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ShiftWorkDao shiftWorkDao;

    @Override
    public ShiftWorkRep addShiftWork(AddShiftWorkRes addShiftWorkRes) throws Exception {
        try {
            List<ShiftWork> shiftWorkList = shiftWorkDao.getAllShiftWork();
            for(ShiftWork shiftWorkItem:shiftWorkList){
                if(shiftWorkItem.getShift_work_id() == addShiftWorkRes.getShift_work_id()){
                    return new ShiftWorkRep(SHIFTWORK_ID_EXIST.getCode(),
                            SHIFTWORK_ID_EXIST.getMessage());
                }
                if(shiftWorkItem.getStart_time().equals(addShiftWorkRes.getStart_time()) &&
                        shiftWorkItem.getEnd_time().equals(addShiftWorkRes.getStart_time())){
                    return new ShiftWorkRep(SHIFT_START_AND_END_TIME_EXIST.getCode(),
                            "ID:"+shiftWorkItem.getShift_work_id()+"與"+
                                    "ID:"+addShiftWorkRes.getShift_work_id()+" "+SHIFT_START_AND_END_TIME_EXIST.getMessage());
                }
            }
            shiftWorkDao.addShiftWork(
                    addShiftWorkRes.getShift_work_id(),
                    addShiftWorkRes.getStart_time(),
                    addShiftWorkRes.getEnd_time());
            return new ShiftWorkRep(SUCCESS_ADD_SHIFTWORK.getCode(),
                    SUCCESS_ADD_SHIFTWORK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ShiftWorkRep updateShiftWork(UpdateShiftWorkRes updateShiftWorkRes) throws Exception {
        try {
            List<ShiftWork> shiftWorkList = shiftWorkDao.getAllShiftWork();
            for(ShiftWork shiftWorkItem:shiftWorkList){
                if(shiftWorkItem.getShift_work_id() == updateShiftWorkRes.getShift_work_id()){
                    continue;
                }
                if(shiftWorkItem.getStart_time().equals(updateShiftWorkRes.getStart_time()) &&
                        shiftWorkItem.getEnd_time().equals(updateShiftWorkRes.getEnd_time())){
                    return new ShiftWorkRep(SHIFT_START_AND_END_TIME_EXIST.getCode(),
                            "ID:"+shiftWorkItem.getShift_work_id()+"與"+
                                    "ID:"+updateShiftWorkRes.getShift_work_id()+" "+SHIFT_START_AND_END_TIME_EXIST.getMessage());
                }
            }
            shiftWorkDao.updateShiftWork(
                    updateShiftWorkRes.getShift_work_id(),
                    updateShiftWorkRes.getStart_time(),
                    updateShiftWorkRes.getEnd_time()
            );
            return new ShiftWorkRep(SUCCESS_UPDATE_SHIFTWORK.getCode(), SUCCESS_UPDATE_SHIFTWORK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ShiftWorkRep deleteShiftWork(int shift_work_id) throws Exception {
        try {
            ShiftWork shiftWork = shiftWorkDao.getShiftWorkByShiftWorkId(shift_work_id);
            if(shiftWork == null){
                return new ShiftWorkRep(NOT_FOUND_SHIFT_WORK.getCode(), NOT_FOUND_SHIFT_WORK.getMessage());
            }
            return new ShiftWorkRep(SUCCESS_DELETE_SHIFTWORK.getCode(), SUCCESS_DELETE_SHIFTWORK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ShiftWorkRep getShiftWorkByShiftWorkId(int shift_work_id) throws Exception {
        try {
            List<ShiftWork> shiftWorkList = shiftWorkDao.getAllShiftWork();
            ShiftWork shiftWork = shiftWorkDao.getShiftWorkByShiftWorkId(shift_work_id);
            if(shiftWork == null){
                return new ShiftWorkRep(NOT_FOUND_SHIFT_WORK.getCode(),
                        NOT_FOUND_SHIFT_WORK.getMessage());
            }
            if(shiftWork.getStart_time()==null){
                return new ShiftWorkRep(SHIFTWORK_START_TIME_NULL.getCode(),
                        SHIFTWORK_START_TIME_NULL.getMessage());
            }
            if(shiftWork.getEnd_time()==null){
                return new ShiftWorkRep(SHIFTWORK_END_TIME_NULL.getCode(),
                        SHIFTWORK_END_TIME_NULL.getMessage());
            }
            for(ShiftWork shiftWorkItem:shiftWorkList){
                if(shiftWorkItem.getShift_work_id() == shiftWork.getShift_work_id()){
                    continue;
                }
                if(shiftWorkItem.getStart_time().equals(shiftWork.getStart_time()) &&
                shiftWorkItem.getEnd_time().equals(shiftWork.getEnd_time())){
                    return new ShiftWorkRep(SHIFT_START_AND_END_TIME_EXIST.getCode(),
                            "ID:"+shiftWorkItem.getShift_work_id()+"與"+
                                    "ID:"+shiftWork.getShift_work_id()+" "+SHIFT_START_AND_END_TIME_EXIST.getMessage());
                }
            }
            return new ShiftWorkRep(shiftWork,SUCCESS_SEARCH_SHIFTWORK.getCode(),
                    SUCCESS_SEARCH_SHIFTWORK.getMessage());
        } catch (Exception e){
            logger.error(e.getMessage());
           throw e;
        }
    }

    @Override
    public ShiftWorkRep getAllShiftWork() {
        try {
            List<ShiftWork> shiftWorkList = shiftWorkDao.getAllShiftWork();
            if(shiftWorkList == null){
                return new ShiftWorkRep(NOT_FOUND_SHIFT_WORK_LIST.getCode(), NOT_FOUND_SHIFT_WORK_LIST.getMessage());
            }
            for(ShiftWork shiftWork : shiftWorkList){
                if(shiftWork == null){
                    return new ShiftWorkRep(NOT_FOUND_SHIFT_WORK.getCode(),
                            NOT_FOUND_SHIFT_WORK.getMessage());
                }
                if(shiftWork.getStart_time()==null){
                    return new ShiftWorkRep(SHIFTWORK_START_TIME_NULL.getCode(),
                            SHIFTWORK_START_TIME_NULL.getMessage());
                }
                if(shiftWork.getEnd_time()==null){
                    return new ShiftWorkRep(SHIFTWORK_END_TIME_NULL.getCode(),
                            SHIFTWORK_END_TIME_NULL.getMessage());
                }
                for(ShiftWork shiftWorkItem:shiftWorkList){
                    if(shiftWorkItem.getShift_work_id() == shiftWork.getShift_work_id()){
                        continue;
                    }
                    if(shiftWorkItem.getStart_time().equals(shiftWork.getStart_time()) &&
                            shiftWorkItem.getEnd_time().equals(shiftWork.getEnd_time())){
                        return new ShiftWorkRep(SHIFT_START_AND_END_TIME_EXIST.getCode(),
                                "ID:"+shiftWorkItem.getShift_work_id()+"與"+
                                        "ID:"+shiftWork.getShift_work_id()+" "+SHIFT_START_AND_END_TIME_EXIST.getMessage());
                    }
                }
            }
            return new ShiftWorkRep(shiftWorkList, SUCCESS_SEARCH_SHIFTWORK.getCode(),SUCCESS_SEARCH_SHIFTWORK.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
