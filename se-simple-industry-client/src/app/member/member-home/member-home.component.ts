import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-member-home',
  templateUrl: './member-home.component.html',
  styleUrls: ['./member-home.component.scss']
})
export class MemberHomeComponent implements OnInit {

  firstName: string;
  lastName: string;

  constructor(
    public authService: AuthService,
    public router: Router
  ) { }

  ngOnInit() {
    this.firstName = this.authService.currentAppuser.firstName;
    this.lastName = this.authService.currentAppuser.lastName;
  }

  logout() {
    this.authService.logoutAppuser();
  }

}
