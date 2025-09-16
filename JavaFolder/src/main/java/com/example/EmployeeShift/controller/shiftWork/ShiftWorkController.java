package com.example.EmployeeShift.controller.shiftWork;


import com.example.EmployeeShift.service.shiftWork.ifs.ShiftWorkService;
import com.example.EmployeeShift.vo.shiftWork.AddShiftWorkRes;
import com.example.EmployeeShift.vo.shiftWork.ShiftWorkRep;
import com.example.EmployeeShift.vo.shiftWork.UpdateShiftWorkRes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.example.EmployeeShift.constants.shiftWork.ShiftWorkMessage.SHIFT_WORK_ID_NULL;

@CrossOrigin("http://localhost:4200")
@RestController
@Validated
public class ShiftWorkController {

    @Autowired
    ShiftWorkService shiftWorkService;

    @GetMapping("/get/shiftwork/{shift_work_id}")
    public ShiftWorkRep getShiftWorkByShiftWorkId(@NotNull(message = SHIFT_WORK_ID_NULL )@PathVariable int shift_work_id) throws Exception{
        return shiftWorkService.getShiftWorkByShiftWorkId(shift_work_id);
    }

    @GetMapping("/getAll/shiftwork")
    public ShiftWorkRep getAllShiftWork() throws Exception{
        return shiftWorkService.getAllShiftWork();
    }

    @PostMapping("/add/shiftwork")
    public ShiftWorkRep addShiftWork(@Valid @RequestBody AddShiftWorkRes addShiftWorkRes) throws Exception{
        return shiftWorkService.addShiftWork(addShiftWorkRes);
    }

    @PutMapping("/update/shiftwork")
    public ShiftWorkRep updateShiftWork(@Valid @RequestBody UpdateShiftWorkRes updateShiftWorkRes) throws Exception{
        return shiftWorkService.updateShiftWork(updateShiftWorkRes);
    }

    @DeleteMapping("/delete/shiftwork/{shift_work_id}")
    public ShiftWorkRep deleteShiftWork(@NotNull(message = SHIFT_WORK_ID_NULL )@PathVariable int shift_work_id) throws Exception {
        return shiftWorkService.deleteShiftWork(shift_work_id);
    }
}
