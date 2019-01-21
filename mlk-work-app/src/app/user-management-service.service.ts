import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import {User} from './user'



export class UserManagementServiceService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
  constructor(private http: HttpClient) { }
  public addUser(user: User): Observable<any>
  {
    return this.http.post('http://localhost:8087/api',user,this.httpOptions);
  }


  public getUser(username: string): Observable<any>
  {
    return this.http.get('http://localhost:8087/api/'+username);
  }
}
