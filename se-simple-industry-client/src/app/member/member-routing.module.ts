import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MemberHomeComponent } from './member-home/member-home.component';

import { AuthGuard } from '../core/guards/auth.guard';

const routes: Routes = [
  {
    path: '', component: MemberHomeComponent, canActivate: [AuthGuard], children: []
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MemberRoutingModule { }
