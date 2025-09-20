import { Component, inject } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UpdateNotifications } from '../../@Dialog/update-notifications/update-notifications';
import { AddNotifications } from '../../@Dialog/add-notifications/add-notifications';
import { HttpClientService } from '../../@Service/HttpClientService';

@Component({
  selector: 'app-back-notifications',
  imports: [],
  templateUrl: './notifications.html',
  styleUrl: './notifications.scss'
})
export class BackNotifications {

  //建構式
  constructor(
    private dialog: MatDialog,
    private http:HttpClientService
  ){}

  //初始化
  ngOnInit(): void {
    //取店家ID
    this.branch_id = 1;
    //取得該店家全部通知
    this.http.getApi(`http://localhost:8080/getAll/notify/${this.branch_id}`).subscribe((getAllnotifyRes:any)=>{
      this.notifyList = getAllnotifyRes.notifyList;
    })
  }

  //全域變數
  branch_id!:number;
  notifyList:any[]=[];

  //新增通知Dialog
  showAddDialog(branch_id:number) {
    const dialogRef = this.dialog.open(AddNotifications, {
      width: '600px',
      height: '450px',
      panelClass: 'custom-dialog',
      data:{
       branch_id:this.branch_id,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    })
  }

  //更新通知Dialog
  showEditDialog(branch_id:number,notify_id:number) {
    const dialogRef = this.dialog.open(UpdateNotifications, {
      width: '600px',
      height: '450px',
      panelClass: 'custom-dialog',
      data:{
        branch_id:branch_id,
        notify_id:notify_id
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    })
  }
}
