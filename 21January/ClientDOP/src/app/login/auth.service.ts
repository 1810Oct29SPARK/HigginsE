import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  userid: number;

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private http: HttpClient, private router: Router) { }

  signInUser(email, password) {


    this.http.post('http://localhost:8083/login/sent', { 'email': email, 'password': password })
      .subscribe((event) => this.router.navigate(['/home']));
  }

  getCurrentUser() {
    return this.userid;
  }

}
