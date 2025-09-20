import { Component, Inject } from '@angular/core';
import { HttpClientService } from '../../@Service/HttpClientService';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { addDays, format, lastDayOfMonth} from 'date-fns';
import { Fail } from '../fail/fail';
import { Success } from '../success/success';

@Component({
  selector: 'app-update-shift-work',
  imports: [FormsModule],
  templateUrl: './update-shift-work.html',
  styleUrl: './update-shift-work.scss'
})
export class UpdateShiftWork {
  //建構式
  constructor(
    private http:HttpClientService,
    private dialogRef:MatDialogRef<UpdateShiftWork>,
    private dialog:MatDialog,
    @Inject(MAT_DIALOG_DATA) public ShiftData: any
  ){}

  //初始化
  ngOnInit(): void {
    this.branch_id = this.ShiftData.branch_id;
    this.employee_id = this.ShiftData.employee_id;

    this.http.getApi(`http://localhost:8080/getAll/shiftById/${this.branch_id}/${this.employee_id}`).subscribe((res:any)=>{
      this.employeeList = res.shiftList.map((item:any)=>({
          ...item,
          isEdit:false
      }))
    })

    this.http.getApi(`http://localhost:8080/getAll/shiftwork`).subscribe((res:any)=>{
      this.timeList = res.shiftWorkList
    })
  }

  //判斷編輯或是只讀
  isEdit = false;
  //全域變數
  tomorrow = format(addDays(new Date(),1),'yyyy-MM-dd');
  limit = format(lastDayOfMonth(this.tomorrow), 'yyyy-MM-dd');
  branch_id!:any;
  employee_id!:any;
  employeeList:any[]=[];
  timeList:any[]=[];
  //要更新資料
  updateDate!:string;
  updateTime!:string;


  //更新班表
  updateItem(oldDate:string){
    if(!this.updateDate || this.updateDate.trim()==""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"更改日期為空"
        }
      })
      return;
    }
    if(!this.updateTime || this.updateTime.trim()==""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"更改時段為空"
        }
      })
      return;
    }

    this.http.getApi(`http://localhost:8080/getAll/shift/${this.branch_id}`).subscribe((updateRes:any)=>{
      let isDuplicate = updateRes.shiftList.some((item:any) =>
        item.branchEmployeeId == this.employee_id && item.apply_date == this.updateDate
      )
      if (isDuplicate) {
        this.dialog.open(Fail, {
          width: '150px',
          data: { message: "更新日期有重複" }
        });
        return;
      }

      const payload = {
          branch_id: this.branch_id,
          employee_id: this.employee_id,
          old: {
            apply_date: oldDate,
            is_working: false,
            shift_work_id:0,
            is_accept: false
          },
          newShift: {
            apply_date: this.updateDate,
            is_working: true,
            shift_work_id: this.updateTime,
            is_accept: true
          }
        };

      this.http.putApi(`http://localhost:8080/update/shiftBatch`, payload).subscribe((updateRes: any) => {
        if (updateRes.code === 200) {
          this.dialog.open(Success, { width: '150px' });
          this.dialogRef.close(true);
        } else {
          this.dialog.open(Fail, { width: '150px', data: { message: updateRes.message } });
        }
      });
    });
  }

  changeType(index:number){
    this.employeeList[index].isEdit = !this.employeeList[index].isEdit;
  }
}
