package com.example.EmployeeShift.constants.notify;

public enum NotifyEnum {
    SUCCESS_ADD_NOTIFTY(200,"新增成功"),
    SUCCESS_SEARCH_NOTIFY(200,"查詢成功"),
    SUCCESS_UPDATE_NOTIFY(200,"更新成功"),
    SUCCESS_DELETE_NOTIFY(200,"刪除成功"),
    START_TIME_BEFORE_TODAY(400,"開始時間比今天還早"),
    END_TIME_BEFORE_START_TIME(400,"結束時間比開始時間早"),
    NOTIFY_TEXT_NULL(400,"通知內容不能為空或全空白"),
    NOTIFY_START_TIME_NULL(400,"開始時間不能為空"),
    NOTIFY_END_TIME_NULL(400,"結束時間不能為空"),
    NOT_FOUND_NOTIFY(404,"找不到此通知"),
    NOT_FOUND_NOTIFY_LIST(404,"找不到此通知列表");

    private int code;
    private String message;

    NotifyEnum(int code, String message) {
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
