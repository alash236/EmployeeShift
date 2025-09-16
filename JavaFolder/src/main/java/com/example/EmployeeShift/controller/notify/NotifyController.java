package com.example.EmployeeShift.controller.notify;

import com.example.EmployeeShift.service.notify.ifs.NotifyService;
import com.example.EmployeeShift.vo.notify.AddNotifyRes;
import com.example.EmployeeShift.vo.notify.NotifyRep;
import com.example.EmployeeShift.vo.notify.UpdateNotifyRes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.EmployeeShift.constants.branch.BranchMessage.BRANCH_ID_MIN;
import static com.example.EmployeeShift.constants.notify.NotifyMessage.NOTIFY_ID_MIN;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
public class NotifyController {
    @Autowired
    NotifyService notifyService;

    @GetMapping("/get/notify/{branch_id}/{notify_id}")
    public NotifyRep getNotifyById(@Min(value = 1,message = BRANCH_ID_MIN)@PathVariable int branch_id,
                                   @Min(value = 1,message = NOTIFY_ID_MIN)@PathVariable int notify_id) throws Exception{
        return notifyService.getNotifyById(branch_id,notify_id);
    }

    @GetMapping("/getAll/notify/{branch_id}")
    public NotifyRep getAllNotify(@Min(value = 1,message = BRANCH_ID_MIN)@PathVariable int branch_id) throws Exception {
        return notifyService.getAllNotify(branch_id);
    }

    @PostMapping("/add/notify")
    public NotifyRep addNotify(@Valid @RequestBody AddNotifyRes addNotifyRes)throws Exception{
        return notifyService.addNotify(addNotifyRes);
    }

    @PutMapping("/update/notify")
    public NotifyRep updateNotify(@Valid @RequestBody UpdateNotifyRes updateNotifyRes) throws Exception{
        return notifyService.updateNotify(updateNotifyRes);
    }

    @DeleteMapping("/delete/notify/{branch_id}/{notify_id}")
    public NotifyRep deleteNotify(@Min(value = 1,message = BRANCH_ID_MIN)@PathVariable int branch_id,
                                  @Min(value = 1,message = NOTIFY_ID_MIN)@PathVariable int notify_id) throws Exception{
        return notifyService.deleteNotify(branch_id,notify_id);
    }

}
