package com.example.EmployeeShift.service.notify.ifs;

import com.example.EmployeeShift.vo.notify.AddNotifyRes;
import com.example.EmployeeShift.vo.notify.NotifyRep;
import com.example.EmployeeShift.vo.notify.UpdateNotifyRes;

public interface NotifyService {
    public NotifyRep addNotify(AddNotifyRes addNotifyRes) throws Exception;

    public NotifyRep updateNotify(UpdateNotifyRes updateNotifyRes) throws Exception;

    public NotifyRep deleteNotify(int branch_id,int notify_id) throws Exception;

    public NotifyRep getNotifyById(int branch_id,int notify_id) throws Exception;

    public NotifyRep getAllNotify(int branch_id) throws Exception;
}
