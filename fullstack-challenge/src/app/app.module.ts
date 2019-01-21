import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { User } from './user';
import { ApiService } from './api.service';
import { DataService } from './data.service';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NormalUserComponent } from './normal-user/normal-user.component';
import { AdminComponent } from './admin/admin.component';
import { AlertComponent } from './alert/alert.component';
import { AlertService } from './alert.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NormalUserComponent,
    AdminComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(
      [
        { path: "", component: LoginComponent}
      ]
    )
  ],
  providers: [User, ApiService, DataService, AlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
