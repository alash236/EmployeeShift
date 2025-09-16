package com.example.EmployeeShift.vo.clock_date;

import com.example.EmployeeShift.entity.clock_date.ClockDate;

import java.util.List;

public class ClockDateRep {

    private int code;
    private String message;
    private ClockDate clockDate;
    private List<ClockDate> clockDateList;

    public ClockDateRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ClockDateRep(ClockDate clockDate,int code, String message) {
        this.code = code;
        this.message = message;
        this.clockDate = clockDate;
    }

    public ClockDateRep(List<ClockDate> clockDateList,int code, String message) {
        this.code = code;
        this.message = message;
        this.clockDateList = clockDateList;
    }

    public ClockDate getClockDate() {
        return clockDate;
    }

    public void setClockDate(ClockDate clockDate) {
        this.clockDate = clockDate;
    }

    public List<ClockDate> getClockDateList() {
        return clockDateList;
    }

    public void setClockDateList(List<ClockDate> clockDateList) {
        this.clockDateList = clockDateList;
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
}
