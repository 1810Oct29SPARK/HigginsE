import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username: string;
  email: string;
  password: string;

  constructor(private service: ApiService, private router: Router) { }

  register(f: NgForm) {
    console.log(f);
    this.username = f.value.username;
    this.email = f.value.email;
    this.password = f.value.password;
    this.service.register(this.username, this.email, this.password).subscribe((data) => {
      console.log(data);
      this.router.navigateByUrl('/');
    })
  }

  ngOnInit() {
  }

}
