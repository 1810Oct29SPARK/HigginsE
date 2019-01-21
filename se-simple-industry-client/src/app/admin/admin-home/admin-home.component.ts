import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss']
})
export class AdminHomeComponent implements OnInit {

  constructor(
    public router: Router,
    public authService: AuthService
  ) { }

  ngOnInit() {
    console.log(this.authService.currentAppuser);
  }

  logout() {
    this.authService.logoutAppuser();
  }

}
