import { InfoService } from './../info.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  name: String;
  email: String;
  password: String;

  constructor(private service: AuthService, private router: Router) { }

  register(f: NgForm) {
    console.log(f);
    this.name = f.value.name;
    this.email = f.value.email;
    this.password = f.value.password;
    this.service.register(this.name, this.email, this.password).subscribe((data) => {
      console.log(data);
      this.router.navigateByUrl('/');
    });
  }

  ngOnInit() {
  }

}
