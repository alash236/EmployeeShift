package com.example.EmployeeShift.constants.clock_date;

public enum ClockDateEnum {
    SUCCESS_ADD_CLOCK(200,"新增打卡成功"),
    SUCCESS_SEAECH_CLOCK(200,"查詢打卡成功"),
    CLOCK_DATE_ERROR(400,"打卡日期錯誤"),
    NOT_FOUND_CLOCK(404,"找不到打卡紀錄"),
    NOT_FOUND_CLOCK_LIST(404,"找不到打卡紀錄列表");;
    private int code;
    private String message;

    ClockDateEnum(int code, String message) {
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
}
