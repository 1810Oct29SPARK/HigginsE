import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule, MatCheckboxModule, MatToolbarModule,
  MatCardModule, MatInputModule, MatDialogModule, MatTableModule, MatMenuModule, MatIconModule, MatProgressSpinnerModule
} from '@angular/material';
import { CommonModule } from '@angular/common';
import { CustomMaterialModule } from './custom-material-module/custom-material-module.module';
import { FormsModule } from '@angular/forms';
import { NavComponent } from './nav/nav.component';
import { SigninComponent } from './login/signin/signin.component';
import { AuthService } from './login/auth.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ManagerHomeComponent } from './manager-home/manager-home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    NavComponent,
    SigninComponent,
    ManagerHomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    CustomMaterialModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
