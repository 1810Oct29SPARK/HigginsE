import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from '../login/login.component';
import { RegistrationComponent } from '../registration/registration.component';
import { MemberHomeComponent } from '../member-home/member-home.component';
import { AdminHomeComponent } from '../admin-home/admin-home.component';

export const routes: Routes = [
  { path:'adminhome', component: AdminHomeComponent },
  { path:'memberhome', component: MemberHomeComponent },
  { path:'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }