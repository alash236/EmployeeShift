import { Routes } from '@angular/router';
import { FrontIndex } from './@FrontStage/front-index/front-index';
import { BackIndex } from './@BackStage/index';





export const routes: Routes =
[
  {path:'',redirectTo:'/FrontIndex',pathMatch:'full'},
  {path:"FrontIndex",component:FrontIndex},
  {path:"BackIndex",component:BackIndex},

];
