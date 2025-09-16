package com.example.EmployeeShift.service.shiftWork.ifs;

import com.example.EmployeeShift.vo.shiftWork.AddShiftWorkRes;
import com.example.EmployeeShift.vo.shiftWork.ShiftWorkRep;
import com.example.EmployeeShift.vo.shiftWork.UpdateShiftWorkRes;

public interface ShiftWorkService {
    public ShiftWorkRep addShiftWork(AddShiftWorkRes addShiftWorkRes) throws Exception;

    public ShiftWorkRep updateShiftWork(UpdateShiftWorkRes updateShiftWorkRes) throws Exception;

    public ShiftWorkRep deleteShiftWork(int shift_work_id) throws Exception;

    public ShiftWorkRep getShiftWorkByShiftWorkId(int shift_work_id) throws Exception;

    public ShiftWorkRep getAllShiftWork();
}
