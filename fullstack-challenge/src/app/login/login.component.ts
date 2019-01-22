import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ApiService } from '../api.service';
import { DataService } from '../data.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    username: string;
    password: string;
    user: any;

    constructor(
        private formBuilder: FormBuilder,
        private service: ApiService,
        private dataService: DataService,
        private router: Router
    ) {}

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

    }

    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;
        if (this.loginForm.invalid) {
            return;
        }
        this.username = this.f.username.value;
        this.password = this.f.password.value;
        this.loading = true;
        this.service.login(this.username, this.password)
            .subscribe(
                data => {
                  console.log(data)
                  this.loading = false;
                  this.user = data;
                  if (this.user != null) {
                    this.dataService.setUser(this.user);
                    if (this.user.roleId.id == 2) {
                      this.router.navigateByUrl('/admin');
                    } else {
                      this.router.navigateByUrl('/user');
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
