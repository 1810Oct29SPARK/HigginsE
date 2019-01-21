import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-member-home',
  templateUrl: './member-home.component.html',
  styleUrls: ['./member-home.component.scss']
})
export class MemberHomeComponent implements OnInit {

  constructor(
    public authService: AuthService,
    public router: Router
  ) { }

  ngOnInit() {
    console.log(this.authService.currentAppuser);
  }

  logout() {
    this.authService.logoutAppuser();
  }

}
