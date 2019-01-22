import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  login(username, password): Observable<any> {
    return this.http.post('http://localhost:8085/user/login', {
      "username": username,
      "password": password
    })
  }

  register(username, email, password): Observable<any> {
    return this.http.post('http://localhost:8085/user/create', {
      "username": username,
      "email": email,
      "password": password,
      "roleId": 1
    });
  }

}
