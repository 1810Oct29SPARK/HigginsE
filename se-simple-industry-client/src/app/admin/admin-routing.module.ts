import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminHomeComponent } from './admin-home/admin-home.component';

import { AuthGuard } from '../core/guards/auth.guard';

const routes: Routes = [
  {
    path: '', component: AdminHomeComponent, canActivate: [AuthGuard], children: []
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
