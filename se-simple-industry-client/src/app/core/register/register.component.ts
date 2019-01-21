import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  userRegisterForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    public router: Router,
    public authService: AuthService
  ) {
    this.userRegisterForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  ngOnInit() {
  }

  userRegister() {
    if (!this.userRegisterForm.valid) {
      console.log('invalid register form');
      return;
    } else {
      console.log(this.userRegisterForm.value);
      this.authService.registerAppuser(JSON.stringify(this.userRegisterForm.value));
    }
  }

}
