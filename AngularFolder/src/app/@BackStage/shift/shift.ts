import { Component} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { AddShiftWork } from '../../@Dialog/add-shift-work/add-shift-work';
import { HttpClientService } from '../../@Service/HttpClientService';
import { AddShiftTime } from '../../@Dialog/add-shift-time/add-shift-time';
import { DayPilot, DayPilotModule } from '@daypilot/daypilot-lite-angular';
import { format, getDaysInMonth, startOfMonth } from 'date-fns';
import {MatButtonModule} from '@angular/material/button';
import { UpdateShiftWork } from '../../@Dialog/update-shift-work/update-shift-work';


@Component({
  selector: 'app-back-shift',
  imports: [FormsModule,DayPilotModule,MatButtonModule],
  templateUrl: './shift.html',
  styleUrl: './shift.scss'
})
export class BackShift {
  //班表初始化
  events: DayPilot.EventData[] = [];
  config: DayPilot.SchedulerConfig = {
    startDate: "",
    days: 7,
    scale: "Hour",
    cellWidth: 70,
    rowHeaderWidth: 210,
    resources: [],
    eventMoveHandling: "Disabled",
    eventResizeHandling: "Disabled",
    // 自訂事件外觀
    onBeforeEventRender: (args) => {
      args.data.cssClass = "shift-event";
    },
    // ✅ 美化 row header
    onBeforeRowHeaderRender: (args) => {
      args.row.html = `
      <div class="row-header">
        <a
          href="javascript:void(0);"
          class="clickable-resource"
          data-id="${args.row.id}"
        >
          ${args.row.name}
        </a>
      </div>
      `;
    },
    onRowClicked: (args) => {
      this.showUpdateShiftWork(String(args.row.id));
    }
  };

  //建構式
  constructor(
    private dialog:MatDialog,
    private http:HttpClientService
  ){}

  //初始化
  ngOnInit(): void {

    //取得班表
    this.http.getApi(`http://localhost:8080/PreSchedule/getScheduleByEmployeeId?employeeId=${}}`).subscribe((res:any)=>{
      this.events = res.shiftList.map((item:any,index:number)=>({
        id:index+1,
        text:"上班",
        start:item.apply_date+"T"+item.startTime,
        end:item.apply_date+"T"+item.endTime,
        resource:item.branchEmployeeId
      }))
    })

    //取得在職員工
    this.http.getApi(`http://localhost:8080/getAllNotResign/branch_employee/${this.branch_id}`).subscribe((employeeRes:any)=>{
      this.employeeList = employeeRes.branchEmployees
      this.config.resources = employeeRes.branchEmployees.map((res:any)=>({
        name:res.branch_employee_name+"("+res.branch_employee_title+")",
        id:res.branch_employee_id
      }))
    })

    //設定班表月分與天數
    this.config.startDate =  new DayPilot.Date(format(this.firstDayOfMonth,'yyyy-MM-dd'));
    this.config.days = getDaysInMonth(this.today)

  }

  //全域變數
  branch_id!:number;
  employeeList:any[]=[];
  today = new Date();
  firstDayOfMonth=startOfMonth(this.today);


  //切換日週月
  currentView: 'day' | 'week' | 'month' = 'week';
  switchView(view:string) {
    if(view === 'day'){
      this.config.days = 1;
      this.config.startDate = new DayPilot.Date();
    }else if(view === 'week'){
      this.config.days = 7;
      this.config.startDate = new DayPilot.Date();
    }else{
      this.config.days = getDaysInMonth(this.today);
      this.config.startDate =  new DayPilot.Date(format(this.firstDayOfMonth,'yyyy-MM-dd'));
    }
  }

  //新增班表Dialog
  showShiftWork() {
    const dialogRef = this.dialog.open(AddShiftWork, {
      width: '500px',
      height: '500px',
      panelClass: 'custom-dialog',
      data: {
        branch_id: this.branch_id,
        employeeList:this.employeeList
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }

  //更新Dialog
  showUpdateShiftWork(employee_id:string) {
    const dialogRef = this.dialog.open(UpdateShiftWork, {
      width: '500px',
      height: '500px',
      panelClass: 'custom-dialog',
      data: {
        branch_id: this.branch_id,
        employee_id:employee_id
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }

  //新增時段Dialog
  showShiftTimeWork() {
    const dialogRef = this.dialog.open(AddShiftTime, {
      width: '40px',
      maxHeight: '90vh',
      panelClass: 'custom-dialog',
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.ngOnInit();
      }
    });
  }

}
