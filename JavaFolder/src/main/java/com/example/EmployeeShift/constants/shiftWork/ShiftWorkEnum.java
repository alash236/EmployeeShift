package com.example.EmployeeShift.constants.shiftWork;

public enum ShiftWorkEnum {
    SUCCESS_ADD_SHIFTWORK(200,"新增班別成功"),
    SUCCESS_SEARCH_SHIFTWORK(200,"查詢班別成功"),
    SUCCESS_UPDATE_SHIFTWORK(200,"更新班別成功"),
    SUCCESS_DELETE_SHIFTWORK(200,"刪除班別成功"),
    SHIFTWORK_ID_EXIST(400,"班別ID已存在"),
    SHIFTWORK_START_TIME_NULL(400,"班別開始時間為空"),
    SHIFTWORK_END_TIME_NULL(400,"班別結束時間為空"),
    SHIFT_START_AND_END_TIME_EXIST(400,"班別開始與結束時間有相同"),
    NOT_FOUND_SHIFT_WORK(404,"找不到班別"),
    NOT_FOUND_SHIFT_WORK_LIST(404,"找不到班別列表");
    private int code;
    private String message;

    ShiftWorkEnum(int code, String message) {
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
