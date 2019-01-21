import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userLoginForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    public router: Router,
    public authService: AuthService
  ) {
    this.userLoginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  ngOnInit() {
  }

  userLogin() {
    if (!this.userLoginForm.valid) {
      console.log('invalid login form');
      return;
    } else {
      console.log(this.userLoginForm.value);
      this.authService.loginAppuser(this.userLoginForm.value);
    }
  }

}
