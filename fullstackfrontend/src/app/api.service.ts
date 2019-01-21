import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  /* Come on pleeeeeeease work */

  login(username, password): Observable<any> {
    return this.http.post('http://localhost:8083/user/login', {
      "username": username,
      "password": password
    })
  }

}