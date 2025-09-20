import { Component, Inject } from '@angular/core';
import { HttpClientService } from '../../@Service/HttpClientService';
import { MatInputModule } from "@angular/material/input";
import { FormsModule } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogActions, MatDialogModule, MatDialog } from '@angular/material/dialog';
import { MatSelectModule } from "@angular/material/select";
import {MatDatepickerModule} from '@angular/material/datepicker';
import { addDays, format, lastDayOfMonth } from 'date-fns';
import { Fail } from '../fail/fail';
import { Success } from '../success/success';

@Component({
  selector: 'app-add-shift-work',
  imports: [MatInputModule, FormsModule, MatSelectModule, MatDatepickerModule, MatInputModule, MatDialogModule],
  templateUrl: './add-shift-work.html',
  styleUrl: './add-shift-work.scss'
})
export class AddShiftWork {

  //建構式
  constructor(
    private http:HttpClientService,
    private dialogRef:MatDialogRef<AddShiftWork>,
    private dialog:MatDialog,
    @Inject(MAT_DIALOG_DATA) public ScheduleData: any
  ){}

  //初始化
  ngOnInit(): void {
    //取店家ID
    this.branch_id = this.ScheduleData.branch_id;

    this.employeeList = this.ScheduleData.employeeList
    console.log(this.employeeList)

    this.http.getApi(`http://localhost:8080/getAll/shiftwork`).subscribe((res:any)=>{
      this.timeList = res.shiftWorkList
    })

  }

  //全域變數
  branch_id!:number;
  selectedEmployee!:string;
  selectedDate!:string;
  selectedTime!:string;
  clockOn!:string;
  clockOff!:string;
  employeeList:any[]=[];
  timeList:any[]=[];
  today = format(new Date,'yyyy-MM-dd');
  tomorrow =format(addDays(this.today,1),'yyyy-MM-dd');
  limit = format(lastDayOfMonth(this.tomorrow),'yyyy-MM-dd');

  addShift(){
    if(this.ScheduleData <= this.today){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"選取日期不能小於等於今日"
        }
      })
      return;
    }
    this.http.getApi(`http://localhost:8080/getAll/shift/${this.branch_id}`).subscribe((res:any)=>{
      let isDuplicate = false;
      for(let item of res.shiftList){
        if(item.branchEmployeeId == this.selectedEmployee && item.apply_date == this.selectedDate){
          isDuplicate = true;
          break;
        }
      }
      if(isDuplicate){
        if(res.code==200){
          this.dialog.open(Fail,{
            width:'150px',
            data:{
              message:"選取日期該員工已排班"
            }
          })
        }
      }else{
        const data = {
          branch_id:this.branch_id,
          employee_id:this.selectedEmployee,
          apply_date:this.selectedDate,
          is_working:null,
          shift_work_id:this.selectedTime,
          is_accept:true
        }
        this.http.putApi(`http://localhost:8080/update/pre_schedule`,data).subscribe((updateRes:any)=>{
          if(updateRes.code == 200){
            this.dialog.open(Success,{
              width:'150px',
            })
          }else{
            this.dialog.open(Fail,{
              width:'150px',
              data:{
                message:updateRes.message
              }
            })
          }
        })
      }
    })
  }

  //取消
  Oncancel(){
    this.dialogRef.close();
  }

}
