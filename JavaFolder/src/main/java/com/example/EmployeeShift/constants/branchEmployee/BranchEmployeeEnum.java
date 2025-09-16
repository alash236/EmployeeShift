package com.example.EmployeeShift.constants.branchEmployee;

public enum BranchEmployeeEnum {
    SUCCESS_ADD_EMPLOYEE(200,"員工新增成功"),
    SUCCESS_SEARCH_EMPLOYEE(200,"查詢員工成功"),
    SUCCESS_UPDATE_EMPLOYEE(200,"更新員工資訊成功"),
    SUCCESS_DELETE_EMPLOYEE(200,"刪除員工資訊成功"),
    SUCCESS_UPDATE_EMPLOYEE_PWD(200,"員工密碼更新成功"),
    SUCCESS_LOGIN(200,"登入成功"),
    PASSWORD_MISMATCH(400,"密碼錯誤"),
    BRANCH_EMPLOYEE_EXIST(400,"該員工已存在"),
    BRANCH_EMPLOYEE_ID_NULL(400,"員工ID不能為空"),
    BRANCH_EMPLOYEE_NAME_NULL(400,"員工名稱不能為空或全空白"),
    BRANCH_EMPLOYEE_STATE_NULL(400,"員工任職狀態不能為空或全空白"),
    BRANCH_EMPLOYEE_EMAIL_NULL(400,"員工信箱不能為空或全空白"),
    BRANCH_EMPLOYEE_PHONE_NULL(400,"員工手機不能為空或全空白"),
    BRANCH_EMPLOYEE_TITLE_NULL(400,"員工職位不能為空或全空白"),
    BRANCH_EMPLOYEE_EMAIL_EXIST(400,"員工信箱不可重複"),
    BRANCH_EMPLOYEE_PHONE_EXIST(400,"員工手機不可重複"),
    NOT_FOUND_EMPLOYEE_LIST(404,"找不到該員工列表"),
    NOT_FOUND_EMPLOYEE(404,"找不到該員工");

    private int code;
    private String message;

    BranchEmployeeEnum(int code, String message) {
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
