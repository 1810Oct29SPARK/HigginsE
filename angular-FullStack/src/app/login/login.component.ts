import { InfoService } from './../info.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  name: string;
  password: string;
  user: any;

  constructor(public formBuilder: FormBuilder, public service: AuthService, private router: Router, private infoservice: InfoService) {

  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      name: ['', Validators.required],
      password: ['', Validators.required]
  });
  }


  get f() { return this.loginForm.controls; }

  onSubmit() {
      this.submitted = true;
      if (this.loginForm.invalid) {
          return;
      }
      this.name = this.f.name.value;
      this.password = this.f.password.value;
      this.loading = true;
      this.service.login(this.name, this.password)
          .subscribe(
              data => {
                console.log(data);
                this.loading = false;
                this.user = data;
                if (this.user != null) {
                  this.infoservice.setUser(this.user);
                  if (this.user.roleid.id === 2) {
                    this.router.navigateByUrl('/admin');
                  } else {
                    this.router.navigateByUrl('/member');
                  }
                } else {
                  this.loginForm.reset();
                }
              },
              error => {
                  this.loading = false;
              });
  }
}

