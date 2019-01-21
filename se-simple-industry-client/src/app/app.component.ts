import { Component, OnInit } from '@angular/core';

import { AuthService } from './core/services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'SE Simple Industry';

  constructor(
    public authService: AuthService
  ) { }

  ngOnInit() {
    const emptyLoginPayload = {};
    this.authService.loginAppuser(emptyLoginPayload);
  }

}
