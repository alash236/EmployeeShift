import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { HttpClientService } from '../../@Service/HttpClientService';
import { addDays, format } from 'date-fns';
import { FormsModule } from '@angular/forms';
import { Fail } from '../fail/fail';
import { Success } from '../success/success';

@Component({
  selector: 'app-update-notifications',
  imports: [FormsModule],
  templateUrl: './update-notifications.html',
  styleUrl: './update-notifications.scss'
})
export class UpdateNotifications {


  //建構式
  constructor(
    private http:HttpClientService,
    private dialogRef:MatDialogRef<UpdateNotifications>,
    private dialog:MatDialog,
    @Inject(MAT_DIALOG_DATA) public branchIDData: any
  ){}

  //初始值
  ngOnInit(): void {
    //取得店家ID
    this.branch_id = this.branchIDData.branch_id
    //取得時段ID
    this.notify_id = this.branchIDData.notify_id
    //取得該時段資訊
    this.http.getApi(`http://localhost:8080/get/notify/${this.branch_id}/${this.notify_id}`).subscribe((getNotifyRes:any)=>{
      this.notifyText = getNotifyRes.notify.notify_text
      this.notifyStartTime = getNotifyRes.notify.notify_startTime
      this.notifyEndTime = getNotifyRes.notify.notify_endTime
    })
  }

  //全域變數
  branch_id!:number;
  notify_id!:number;
  notifyText!:string;
  notifyStartTime!:string;
  notifyEndTime!:string;
  today = format(new Date(),'yyyy-MM-dd');
  after = format(addDays(new Date(),1),'yyyy-MM-dd');

  //更新通知
  updateNotify(){
    if(!this.notifyText || this.notifyText == ""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"通知內容不能為空"
        }
      })
      return;
    }
    if(!this.notifyStartTime || this.notifyStartTime==""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"開始時間不能為空"
        }
      })
      return
    }
    if(!this.notifyEndTime || this.notifyEndTime==""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"結束時間不能為空"
        }
      })
      return
    }
    if(this.notifyEndTime <= this.today){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"結束日期不能小於今日"
        }
      })
      return;
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
      notify_id:this.notify_id,
      notify_text:this.notifyText,
      notify_startTime:this.notifyStartTime,
      notify_endTime:this.notifyEndTime
    }
    this.http.putApi(`http://localhost:8080/update/notify`,data).subscribe((updateNotifyRes:any)=>{
      if(updateNotifyRes.code == 200){
        this.dialog.open(Success,{
          width:'150px'
        })
        this.dialogRef.close(true);
      }else{
        this.dialog.open(Fail,{
          width:'150px',
          data:{
            message:updateNotifyRes.message
          }
        })
        return;
      }
    })
  }

  //刪除通知
  deleteNotify(){
    this.http.delApi(`http://localhost:8080/delete/notify/${this.branch_id}/${this.notify_id}`).subscribe((deleteNotifyRes:any)=>{
      if(deleteNotifyRes.code == 200){
        this.dialog.open(Success,{
          width:'150px'
        })
        this.dialogRef.close(true);
      }else{
        this.dialog.open(Fail,{
          width:'150px',
          data:{
            message:deleteNotifyRes.message
          }
        })
        return;
      }
    })
  }
}
