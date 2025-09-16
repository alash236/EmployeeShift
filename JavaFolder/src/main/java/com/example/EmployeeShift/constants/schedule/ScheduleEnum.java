package com.example.EmployeeShift.constants.schedule;

public enum ScheduleEnum {
    SUCCESS_ADD_SCHEDULE(200,"新增班表成功"),
    SUCCESS_SEARCH_SCHEDULE(200,"查詢班表成功"),
    SUCCESS_UPDATE_SCHEDULE(200,"更新班表成功"),
    SUCCESS_DELETE_SCHEDULE(200,"刪除班表成功"),
    WORK_ERROR(400,"尚未給班"),
    ACCEPT_ERROR(400,"尚未批准"),
    NOT_FOUND_SCHEDULE_LIST(404,"找不到上班列表"),
    NOT_FOUND_SCHEDULE(404,"找不到上班班表"),
    EMPLOYEE_RESIGN(400,"該員工已離職");


    private int code;
    private String message;

    ScheduleEnum(int code, String message) {
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
