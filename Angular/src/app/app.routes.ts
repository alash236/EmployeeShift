import { Routes } from '@angular/router';
import { BackIndex } from './@BackStage/index';
import { LoginComponent } from './@FrontStage/login/login.component';
import { SchedulingComponent } from './@FrontStage/scheduling/scheduling.component';
import { LeaveFormComponent } from './@FrontStage/leave-form/leave-form.component';





export const routes: Routes =
[
  {path:'',component:LoginComponent},
  {path:'scheduling',component:SchedulingComponent},
  {path: 'leave', component: LeaveFormComponent},
  {path:"backindex",component:BackIndex}

];
