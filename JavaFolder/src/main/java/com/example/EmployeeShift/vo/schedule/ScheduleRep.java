package com.example.EmployeeShift.vo.schedule;

import com.example.EmployeeShift.entity.schedule.Schedule;

import java.util.List;

public class ScheduleRep {
    private int code;
    private String message;
    private Schedule schedule;
    private List<?> scheduleList;

    public ScheduleRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ScheduleRep(Schedule schedule,int code, String message) {
        this.code = code;
        this.message = message;
        this.schedule = schedule;
    }

    public ScheduleRep(List<?> scheduleList,int code, String message) {
        this.code = code;
        this.message = message;
        this.scheduleList = scheduleList;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<?> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<?> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
