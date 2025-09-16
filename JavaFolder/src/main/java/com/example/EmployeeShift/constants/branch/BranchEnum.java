package com.example.EmployeeShift.constants.branch;

public enum BranchEnum {
    SUCCESS_ADD_BRANCH(200,"新增店家成功"),
    SUCCESS_SEARCH_BRANCH(200,"查詢店家成功"),
    BRANCH_ID_ZERO(400,"店家ID不能0"),
    BRANCH_NAME_SEARCH_NULL(400,"店家名稱不能為空或全空白"),
    BRANCH_LOCATION_SEARCH_NULL(400,"店家位址不能為空"),
    BRANCH_PHONE_SEARCH_NULL(400,"店家手機不能為空"),
    BRANCH_EMAIL_SEARCH_NULL(400,"店家信箱不能為空"),
    NOT_FOUND_BRANCH(404,"找不到店家資訊");


    private int code;
    private String message;

    BranchEnum(int code, String message) {
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
