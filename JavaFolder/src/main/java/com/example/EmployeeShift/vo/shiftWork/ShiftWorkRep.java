package com.example.EmployeeShift.vo.shiftWork;

import com.example.EmployeeShift.entity.shiftWork.ShiftWork;

import java.util.List;

public class ShiftWorkRep {
    private int code;
    private String message;
    private ShiftWork shiftWork;
    private List<ShiftWork> shiftWorkList;

    public ShiftWorkRep(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ShiftWorkRep(ShiftWork shiftWork,int code, String message) {
        this.code = code;
        this.message = message;
        this.shiftWork = shiftWork;
    }

    public ShiftWorkRep(List<ShiftWork> shiftWorkList, int code, String message) {
        this.shiftWorkList = shiftWorkList;
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

    public ShiftWork getShiftWork() {
        return shiftWork;
    }

    public void setShiftWork(ShiftWork shiftWork) {
        this.shiftWork = shiftWork;
    }

    public List<ShiftWork> getShiftWorkList() {
        return shiftWorkList;
    }

    public void setShiftWorkList(List<ShiftWork> shiftWorkList) {
        this.shiftWorkList = shiftWorkList;
    }
}
