package com.example.EmployeeShift.vo.pre_schedule;

import com.example.EmployeeShift.entity.pre_schedule.PreSchedule;

import java.util.List;

public class PreScheduleRep {
    private int code;
    private String message;
    private PreSchedule preSchedule;
    private List<PreSchedule> preScheduleList;

    public PreScheduleRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public PreScheduleRep(PreSchedule preSchedule,int code, String message) {
        this.code = code;
        this.message = message;
        this.preSchedule = preSchedule;
    }

    public PreScheduleRep(List<PreSchedule> preScheduleList, int code, String message) {
        this.preScheduleList = preScheduleList;
        this.code = code;
        this.message = message;
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

    public PreSchedule getPreSchedule() {
        return preSchedule;
    }

    public void setPreSchedule(PreSchedule preSchedule) {
        this.preSchedule = preSchedule;
    }

    public List<PreSchedule> getPreScheduleList() {
        return preScheduleList;
    }

    public void setPreScheduleList(List<PreSchedule> preScheduleList) {
        this.preScheduleList = preScheduleList;
    }
}
