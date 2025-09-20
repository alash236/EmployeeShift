import { Component, Inject, inject } from '@angular/core';
import { addDays, format } from 'date-fns';
import { HttpClientService } from '../../@Service/HttpClientService';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { Success } from '../success/success';
import { Fail } from '../fail/fail';

@Component({
  selector: 'app-add-notifications',
  imports: [FormsModule],
  templateUrl: './add-notifications.html',
  styleUrl: './add-notifications.scss'
})

export class AddNotifications {

  //建構式
  constructor(
    private http:HttpClientService,
    private dialogRef:MatDialogRef<AddNotifications>,
    private dialog:MatDialog,
    @Inject(MAT_DIALOG_DATA) public branchIDData: any){}

  //初始化
  ngOnInit(): void {
    this.branch_id=1;
    this.http.getApi(`http://localhost:8080/getAll/notify/${this.branch_id}`).subscribe((notifyRes:any)=>{
      notifyRes.notifyList.forEach((element:any) => {
        this.max = Math.max(this.max,element.notify_id);
      });
    })
  }


  //全域變數
  today = format(new Date(), "yyyy-MM-dd");
  after = format(addDays(new Date(),1), "yyyy-MM-dd");
  branch_id!:number;
  max:number=0;
  notifyText!:string;
  notifyStartTime!:string;
  notifyEndTime!:string;

  //新增通知
  addNotify(){
    if(!this.notifyText || this.notifyText.trim() === ""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"通知內容不能為空"
        }
      })
      return;
    }
    if(!this.notifyStartTime || this.notifyStartTime.trim()===""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"開始日期不能為空"
        }
      })
      return
    }
    if(!this.notifyEndTime || this.notifyEndTime.trim()===""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"結束日期不能為空"
        }
      })
      return
    }
    if(this.notifyStartTime > this.notifyEndTime){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"開始日期不能大於結束日期"
        }
      })
      return;
    }
    const data = {
      branch_id:this.branch_id,
      notify_id:this.max+1,
      notify_text:this.notifyText,
      notify_startTime:this.notifyStartTime,
      notify_endTime:this.notifyEndTime
    }
    this.http.postApi(`http://localhost:8080/add/notify`,data).subscribe((addNotifyRes:any)=>{
      if(addNotifyRes.code == 200){
        this.dialog.open(Success,{
          width:'150px'
        });
        this.dialogRef.close(true);
      }else{
        this.dialog.open(Fail,{
          width:'150px',
          data:{
            message:addNotifyRes.message
          }
        })
        return;
      }
    })
  }

  //取消
  OnCancel(){
    this.dialogRef.close();
  }
}
