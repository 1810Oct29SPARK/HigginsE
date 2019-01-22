import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './auth.service';
import { InfoService } from './info.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { Routes, RouterModule } from '@angular/router';



import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { MemberComponent } from './member/member.component';
import { NavComponent } from './nav/nav.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'member', component: MemberComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent}
  ];
@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    MemberComponent,
    NavComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    MDBBootstrapModule.forRoot(),
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [
    InfoService,
    AuthService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
