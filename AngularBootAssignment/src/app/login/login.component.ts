import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public http: HttpClient, public route: RouterLink) { }

  ngOnInit() {
  }

  onSubmit(){
    this.http.get("http://localhost:8087/members/login").
    subscribe((data) => {
      if(data == "admin"){
        this.route.routerLink=("/adminPage");
      }
    });
  }
}
