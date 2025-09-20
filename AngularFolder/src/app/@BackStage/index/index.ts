import { HttpClient } from '@angular/common/http';
import { Service } from './../../@Service/service';
import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { BackEmployeeManger } from "../employee_manger/employee-manger";
import { BackNotifications } from "../notifications/notifications";
import { BackLeave } from '../leave/leave';
import { BackShift } from '../shift/shift';
import { BackOpinion } from '../opinion/opinion';
import { BackClock } from "../clock/clock";

@Component({
  selector: 'app-back-index',
  imports: [MatIconModule, BackEmployeeManger, BackLeave, BackNotifications, BackOpinion, BackShift, BackClock],
  templateUrl: './index.html',
  styleUrl: './index.scss'
})



export class BackIndex {

  //判斷畫面布林值
  isBackEmployeeManger = false;
  isBackClock = false;
  isBackOpinions = false;
  isBackLeave = false;
  isBackShift = false;
  isBackNotifications = false;


  //全域變數
  storeName: string = '八車';

  //切換方法
  toggleIconBackClock() {
    this.isBackEmployeeManger = false;
    this.isBackOpinions = false;
    this.isBackLeave = false;
    this.isBackNotifications = false;
    this.isBackShift = false;
    this.isBackClock = true;
  }

  toggleIconBackEmployeeMangerState() {
    this.isBackEmployeeManger = true;
    this.isBackOpinions = false;
    this.isBackLeave = false;
    this.isBackNotifications = false;
    this.isBackShift = false;
    this.isBackClock = false;
  }
  toggleIconBackOpinionsState() {
    this.isBackEmployeeManger = false;
    this.isBackOpinions = true;
    this.isBackLeave = false;
    this.isBackNotifications = false;
    this.isBackShift = false;
    this.isBackClock = false;
  }
  toggleIconBackShiftState() {
    this.isBackEmployeeManger = false;
    this.isBackOpinions = false;
    this.isBackLeave = false;
    this.isBackNotifications = false;
    this.isBackShift = true;
    this.isBackClock = false;
  }
  toggleIconBackLeaveState() {
    this.isBackEmployeeManger = false;
    this.isBackOpinions = false;
    this.isBackLeave = true;
    this.isBackNotifications = false;
    this.isBackShift = false;
     this.isBackClock = false;
  }
  toggleIconBackNotificationsState() {
    this.isBackEmployeeManger = false;
    this.isBackOpinions = false;
    this.isBackLeave = false;
    this.isBackNotifications = true;
    this.isBackShift = false;
     this.isBackClock = false;
  }

}

