import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss']
})
export class AdminHomeComponent implements OnInit {

  firstName: string;
  lastName: string;

  constructor(
    public router: Router,
    public authService: AuthService
  ) { }

  ngOnInit() {
    this.firstName = this.authService.currentAppuser.firstName;
    this.lastName = this.authService.currentAppuser.lastName;
  }

  logout() {
    this.authService.logoutAppuser();
  }

}
