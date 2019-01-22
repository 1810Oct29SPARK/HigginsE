import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  user: any;
  userid: number;

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private http: HttpClient, private router: Router) { }

  signInUser(email, password): Observable<any> {
    return this.http.post('http://localhost:8083/login/sent', { 'email': email, 'password': password });
  }

  getCurrentUser() {
    return this.userid;
  }

  setUser(user) {
    this.user = user;
  }

  getUser() {
    return this.user;
  }
}
