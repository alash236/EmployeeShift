package com.example.EmployeeShift.constants.preSchedule;

public enum PreScheduleEnum {
    SUCCESS_ADD_PRESCHEDULE(200,"新增預排成功"),
    SUCCESS_UPDATE_PRESCHEDULE(200,"更新預排成功"),
    SUCCESS_SEARCH_PRESCHEDULE(200,"查詢預排成功"),
    SUCCESS_DELETE_PRESCHEDULE(200,"刪除預排班成功"),
    EMPLOYEE_RESIGN(400,"該員工已離職不能排班"),
    PRESCHEDULE_DUPLICATE(400,"該員工預排日期已重複"),
    EMPLOYEE_NOT_FOUND_PRESCHEDULE(400,"員工不存在無法查詢該預排班"),
    NOT_FOUND_PRESCHEDULE(404,"找不到預排班別"),
    NOT_FOUND_PRESCHEDULE_LIST(404,"找不到預排班別列表");

    private int code;
    private String message;

    PreScheduleEnum(int code, String message) {
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
