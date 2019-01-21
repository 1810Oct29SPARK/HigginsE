import { Component } from '@angular/core';

import { LoginComponent } from './login/login.component';
import { MemberHomeComponent } from './member-home/member-home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { RegistrationComponent } from './registration/registration.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mlk-work';
}
