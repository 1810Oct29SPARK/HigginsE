import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

/* Yeah I'm bad at routing */

import { AppComponent } from './app.component';
import { User } from './user';
import { DataService } from './data.service';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
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
  providers: [User, DataService,],
  bootstrap: [AppComponent]
})
export class AppModule { }
