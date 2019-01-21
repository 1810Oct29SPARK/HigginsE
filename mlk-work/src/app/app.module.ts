import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MemberHomeComponent } from './member-home/member-home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { RegistrationComponent } from './registration/registration.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'mlk/login',
    pathMatch: 'full'
  },
  {
    path: 'mlk/login',
    component: LoginComponent
  },
  {
    path: 'mlk/member',
    component: MemberHomeComponent,
  },
  {
    path: 'mlk/admin',
    component: AdminHomeComponent,
  },
  {
    path: 'mlk/registration',
    component: RegistrationComponent,
  },
  {
    path: '**',
    redirectTo: 'mlk/login',
    pathMatch: 'full'
  }
];



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MemberHomeComponent,
    AdminHomeComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule, 
    RouterModule.forRoot(
      appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
