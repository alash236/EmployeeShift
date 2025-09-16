package com.example.EmployeeShift.vo.notify;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_NULL;
import static com.example.EmployeeShift.constants.notify.NotifyMessage.*;

public class UpdateNotifyRes {
    @NotNull(message = BRANCH_ID_NULL)
    @Min(value = 1,message = BRANCH_ID_MIN)
    private int branch_id;

    @NotNull(message = NOTIFY_ID_NULL)
    @Min(value = 1,message = NOTIFY_ID_MIN)
    private int notify_id;

    private String notify_text;

    private LocalDate notify_startTime;

    @Future(message = NOTIFY_END_TIME_BERFORE_TODAY)
    private LocalDate notify_endTime;

    public UpdateNotifyRes(int branch_id, LocalDate notify_endTime, int notify_id, LocalDate notify_startTime, String notify_text) {
        this.branch_id = branch_id;
        this.notify_endTime = notify_endTime;
        this.notify_id = notify_id;
        this.notify_startTime = notify_startTime;
        this.notify_text = notify_text;
    }

    public LocalDate getNotify_endTime() {
        return notify_endTime;
    }

    public void setNotify_endTime(LocalDate notify_endTime) {
        this.notify_endTime = notify_endTime;
    }

    public int getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(int notify_id) {
        this.notify_id = notify_id;
    }

    public LocalDate getNotify_startTime() {
        return notify_startTime;
    }

    public void setNotify_startTime(LocalDate notify_startTime) {
        this.notify_startTime = notify_startTime;
    }

    public String getNotify_text() {
        return notify_text;
    }

    public void setNotify_text(String notify_text) {
        this.notify_text = notify_text;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
}
