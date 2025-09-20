import { Component, Inject } from '@angular/core';
import { HttpClientService } from '../../@Service/HttpClientService';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { Fail } from '../fail/fail';
import { Success } from '../success/success';

@Component({
  selector: 'app-update-clock',
  imports: [FormsModule],
  templateUrl: './update-clock.html',
  styleUrl: './update-clock.scss'
})
export class UpdateClock {

  //建構式
  constructor(
    private http:HttpClientService,
    private dialog:MatDialog,
    @Inject (MAT_DIALOG_DATA) public clockInfo: any
  ){}

  //初始化
  ngOnInit(): void {

    //取得該員工所有打卡天數
    this.http.getApi(`http://localhost:8080/clock/get_one?employee_id=${this.clockInfo.id}`).subscribe((clockRes:any)=>{
      this.clockList = clockRes.clockDateInfoResList.map((item:any)=>({
        ...item,
        date:item.clockOff.substring(0,10),
        clockOn:item.clockOn.substring(11,16),
        clockOff:item.clockOff.substring(11,16)
      }))
    })
  }

  //全域變數
  clockList:any[]=[]
  isEdit = false;

  changeType(){
    this.isEdit = !this.isEdit;
  }

  //更新時間
  updateClock(clockOn:string,clockOff:string){
    if(!clockOn || clockOn == ""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"上班時間為空"
        }
      })
      return;
    }
    if(!clockOff || clockOff == ""){
      this.dialog.open(Fail,{
        width:'150px',
        data:{
          message:"下班時間為空"
        }
      })
      return;
    }
    const data = this.clockList.map((item:any)=>{
      let newItem = {
        ...item,
        clockOn:item.date+"T"+item.clockOn,
        clockOff:item.date+"T"+item.clockOff
      }
      delete newItem.date
      return{
        ...newItem
      }
    })
    console.log(data)
    this.http.postApi('',data).subscribe((updateRes:any)=>{
      if(updateRes.code == 200){
        this.dialog.open(Success,{
          width:'150px'
        })
        this.ngOnInit();
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
}
