import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ApiService } from '../api.service';


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
            .pipe(first())
            .subscribe(
                data => {
                  console.log(data)
                },
                error => {
                    this.loading = false;
                });
    }
}