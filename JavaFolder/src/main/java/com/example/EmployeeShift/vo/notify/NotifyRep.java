package com.example.EmployeeShift.vo.notify;

import com.example.EmployeeShift.entity.notify.Notify;

import java.util.List;

public class NotifyRep {
    private int code;
    private String message;
    private Notify notify;
    private List<Notify> notifyList;

    public NotifyRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public NotifyRep(Notify notify,int code, String message) {
        this.code = code;
        this.message = message;
        this.notify = notify;
    }

    public NotifyRep(List<Notify> notifyList,int code, String message) {
        this.code = code;
        this.message = message;
        this.notifyList = notifyList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    public List<Notify> getNotifyList() {
        return notifyList;
    }

    public void setNotifyList(List<Notify> notifyList) {
        this.notifyList = notifyList;
    }
}
