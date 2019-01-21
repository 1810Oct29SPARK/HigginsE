import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

import { Appuser } from '../../shared/models/appuser';
import { LoginPayload } from '../../shared/models/login-payload';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public static baseUrl = 'http://localhost:8081/';
  public static jsonHttpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  currentAppuser: Appuser = null;
  currentUserRole = 0;

  constructor(
    public http: HttpClient,
    public router: Router
  ) { }

  registerAppuser(requestBody: string): void {
    this.http.post<Appuser>(AuthService.baseUrl + 'appuser/register', requestBody)
      .subscribe((response) => {
        this.currentAppuser = response;
        this.currentUserRole = this.currentAppuser.userRole.userRoleId;
        localStorage.setItem('userJws', this.currentAppuser.jws);
        this.router.navigate(['/member']);
      });
  }

  loginAppuser(payloadBody: Object): void {

    const requestBody = new LoginPayload();
    requestBody.email = payloadBody['email'];
    requestBody.password = payloadBody['password'];
    if (!requestBody.email) {
      if (localStorage.length > 0) {
        requestBody.jws = localStorage.getItem('userJws');
      }
    }

    this.http.post<Appuser>(AuthService.baseUrl + 'appuser/login', JSON.stringify(requestBody), AuthService.jsonHttpOptions)
      .subscribe((response) => {
        this.currentAppuser = response;
        this.currentUserRole = this.currentAppuser.userRole.userRoleId;
        if (this.currentAppuser.jws) {
          localStorage.setItem('userJws', this.currentAppuser.jws);
        }
        if (this.currentUserRole === 1) {
          this.router.navigate(['/admin']);
        } else if (this.currentUserRole === 2) {
          this.router.navigate(['/member']);
        }
      });

  }

  logoutAppuser() {
    this.currentAppuser = null;
    this.currentUserRole = 0;
    localStorage.clear();
    this.router.navigate(['/']);
  }

}
