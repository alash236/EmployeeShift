package com.example.EmployeeShift.service.notify.impl;

import com.example.EmployeeShift.dao.branch.BranchDao;
import com.example.EmployeeShift.dao.notify.NotifyDao;
import com.example.EmployeeShift.entity.branch.Branch;
import com.example.EmployeeShift.entity.notify.Notify;
import com.example.EmployeeShift.service.notify.ifs.NotifyService;
import com.example.EmployeeShift.vo.notify.AddNotifyRes;
import com.example.EmployeeShift.vo.notify.NotifyRep;
import com.example.EmployeeShift.vo.notify.UpdateNotifyRes;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.EmployeeShift.constants.branch.BranchEnum.NOT_FOUND_BRANCH;
import static com.example.EmployeeShift.constants.notify.NotifyEnum.*;

@Service
public class NotifyImpl implements NotifyService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private LocalDate today = LocalDate.now();

    @Autowired
    BranchDao branchDao;

    @Autowired
    NotifyDao notifyDao;


    @Override
    @Transactional(rollbackOn = Exception.class)
    public NotifyRep addNotify(AddNotifyRes addNotifyRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(addNotifyRes.getBranch_id());
            if(branch==null){
                return new NotifyRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //判斷更新日期是否比今天早
            if(addNotifyRes.getNotify_startTime().isBefore(today)){
                return new NotifyRep(START_TIME_BEFORE_TODAY.getCode(),START_TIME_BEFORE_TODAY.getMessage());
            }
            //判斷更新日期是否比開始日期早
            if(addNotifyRes.getNotify_endTime().isBefore(addNotifyRes.getNotify_startTime())){
                return new NotifyRep(END_TIME_BEFORE_START_TIME.getCode(),END_TIME_BEFORE_START_TIME.getMessage());
            }

            //新增通知
            notifyDao.addNotify(
                    addNotifyRes.getBranch_id(),
                    addNotifyRes.getNotify_id(),
                    addNotifyRes.getNotify_text(),
                    addNotifyRes.getNotify_startTime(),
                    addNotifyRes.getNotify_endTime()
            );
            return new NotifyRep(SUCCESS_ADD_NOTIFTY.getCode(),SUCCESS_ADD_NOTIFTY.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public NotifyRep updateNotify(UpdateNotifyRes updateNotifyRes) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(updateNotifyRes.getBranch_id());
            if(branch==null){
                return new NotifyRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //取得單一通知並驗證
            Notify notify = notifyDao.getNotifyById(updateNotifyRes.getBranch_id(),updateNotifyRes.getNotify_id());
            if(notify == null){
                return new NotifyRep(NOT_FOUND_NOTIFY.getCode(), NOT_FOUND_NOTIFY.getMessage());
            }
            NotifyRep notifyRep = validNotify(notify);
            if(notifyRep!=null){
                return notifyRep;
            }

            //當雙方值都為空 雙方取得先前值進行比對
            if(updateNotifyRes.getNotify_endTime()==null &&
                    updateNotifyRes.getNotify_startTime()==null &&
                    notify.getNotify_endTime().isBefore(notify.getNotify_startTime())){
                return new NotifyRep(END_TIME_BEFORE_START_TIME.getCode(), END_TIME_BEFORE_START_TIME.getMessage());
            }

            //當結束日期傳入值為空並且開始日期傳入值不是空 結束日期取先前值進行比對
            if(updateNotifyRes.getNotify_endTime()==null &&
                    updateNotifyRes.getNotify_startTime()!=null &&
                    notify.getNotify_endTime().isBefore(updateNotifyRes.getNotify_startTime())){
                return new NotifyRep(END_TIME_BEFORE_START_TIME.getCode(), END_TIME_BEFORE_START_TIME.getMessage());
            }

            //當雙方值都不為空 取傳入值進行比對
            if(updateNotifyRes.getNotify_startTime()!=null &&
                    updateNotifyRes.getNotify_endTime()!=null &&
                    updateNotifyRes.getNotify_endTime().isBefore(updateNotifyRes.getNotify_startTime())){
                return new NotifyRep(END_TIME_BEFORE_START_TIME.getCode(), END_TIME_BEFORE_START_TIME.getMessage());
            }

            //當結束日期傳入值為部為空並且開始日期傳入值是空 開始日期取先前值進行比對
            if(updateNotifyRes.getNotify_startTime()==null &&
                    updateNotifyRes.getNotify_endTime()!=null &&
                    updateNotifyRes.getNotify_endTime().isBefore(notify.getNotify_startTime())){
                return new NotifyRep(END_TIME_BEFORE_START_TIME.getCode(), END_TIME_BEFORE_START_TIME.getMessage());
            }

            //更新通知
            notifyDao.updateNotify(
                    updateNotifyRes.getBranch_id(),
                    updateNotifyRes.getNotify_id(),
                    updateNotifyRes.getNotify_text(),
                    updateNotifyRes.getNotify_startTime(),
                    updateNotifyRes.getNotify_endTime()
            );
            return new NotifyRep(SUCCESS_UPDATE_NOTIFY.getCode(), SUCCESS_UPDATE_NOTIFY.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public NotifyRep deleteNotify(int branch_id,int notify_id) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new NotifyRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //先取得單一通知是否存在
            Notify notify = notifyDao.getNotifyById(branch_id,notify_id);
            if(notify == null){
                return new NotifyRep(NOT_FOUND_NOTIFY.getCode(), NOT_FOUND_NOTIFY.getMessage());
            }

            //刪除通知
            notifyDao.deleteNotify(branch_id,notify_id);
            return new NotifyRep(SUCCESS_DELETE_NOTIFY.getCode(), SUCCESS_DELETE_NOTIFY.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public NotifyRep getNotifyById(int branch_id,int notify_id) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new NotifyRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }

            Notify notify = notifyDao.getNotifyById(branch_id,notify_id);
            NotifyRep notifyRep = validNotify(notify);
            //取得單一通知並驗證通知
            if(notifyRep!=null){
                return notifyRep;
            }
            return new NotifyRep(notify,SUCCESS_SEARCH_NOTIFY.getCode(),SUCCESS_SEARCH_NOTIFY.getMessage());

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public NotifyRep getAllNotify(int branch_id) throws Exception {
        try {
            Branch branch = branchDao.getBranchById(branch_id);
            if(branch==null){
                return new NotifyRep(NOT_FOUND_BRANCH.getCode(), NOT_FOUND_BRANCH.getMessage());
            }
            //取額全部通知並比對是否全空
            List<Notify> notifies = notifyDao.getAllNotify(branch_id);
            if(notifies == null){
                return new NotifyRep(NOT_FOUND_NOTIFY_LIST.getCode(), NOT_FOUND_NOTIFY_LIST.getMessage());
            }

            //比對各個通知並驗證
            for(Notify notify:notifies){
                NotifyRep notifyRep = validNotify(notify);
                if(notifyRep!=null){
                    return notifyRep;
                }
            }
            return new NotifyRep(notifies,SUCCESS_SEARCH_NOTIFY.getCode(), SUCCESS_SEARCH_NOTIFY.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /***
     *驗證通知是否存在
     * 比對內容時間是否為空
     * 比對結束日期是否小於開始日期
     */
    private NotifyRep validNotify(Notify notify){
        if(notify == null){
            return new NotifyRep(NOT_FOUND_NOTIFY.getCode(),NOT_FOUND_NOTIFY.getMessage());
        }
        if(notify.getNotify_text() == null || notify.getNotify_text().equals("")){
            return new NotifyRep(NOTIFY_TEXT_NULL.getCode(),NOTIFY_TEXT_NULL.getMessage());
        }
        if(notify.getNotify_startTime() == null){
            return new NotifyRep(NOTIFY_START_TIME_NULL.getCode(), NOTIFY_START_TIME_NULL.getMessage());
        }
        if(notify.getNotify_endTime() == null){
            return new NotifyRep(NOTIFY_END_TIME_NULL.getCode(), NOTIFY_END_TIME_NULL.getMessage());
        }
        if(notify.getNotify_endTime().isBefore(notify.getNotify_startTime())){
            return new NotifyRep(END_TIME_BEFORE_START_TIME.getCode(),END_TIME_BEFORE_START_TIME.getMessage());
        }
        return null;
    }
}
