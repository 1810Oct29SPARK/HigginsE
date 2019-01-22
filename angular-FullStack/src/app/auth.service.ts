import { AdminComponent } from './admin/admin.component';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MemberComponent } from './member/member.component';



@Injectable({
  providedIn: 'root'
})
export class AuthService {



  constructor(private http: HttpClient) { }

  login(name, password): Observable<any> {
    return this.http.post('http://localhost:8083/user/login', {
      'name': name,
    'password': password
    });
  }

  register(name, email, password): Observable<any> {
    return this.http.post('http://localhost:8083/user/create', {
      'name': name,
      'email': email,
      'password': password,
      'roleid': 1
    });
  }
}
