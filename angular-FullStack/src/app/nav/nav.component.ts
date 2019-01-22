import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})


export class NavComponent implements OnInit {

  loginForm: FormGroup;
    loading = false;
    submitted = false;
    username: string;
    password: string;

    constructor(
      private formBuilder: FormBuilder,
      private service: AuthService,
  ) {}
    ngOnInit() {
      this.loginForm = this.formBuilder.group({
          username: ['', Validators.required],
          password: ['', Validators.required]
      });

  }

  // convenience getter for easy access to form fields

}
