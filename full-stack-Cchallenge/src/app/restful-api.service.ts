import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class RestfulAPIService {

  constructor(private http: HttpClient){ }

  login(username, password): Observable<any> {
    return this.http.post('http://localhost:8087/users/login', {
    "username": username,
    "password": password
    })
  }

}
