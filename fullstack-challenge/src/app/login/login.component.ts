import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ApiService } from '../api.service';
import { AlertService } from '../alert.service';


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

    constructor(
        private formBuilder: FormBuilder,
        private service: ApiService,
        private alertService: AlertService
    ) {}

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

    }

    // convenience getter for easy access to form fields
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
            .pipe(first())
            .subscribe(
                data => {
                  console.log(data)
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
