import {Injectable} from "@angular/core";
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable()
export class UserService {
    data:any;
    username:string;
    password:string;
  constructor(private http: HttpClient) {}

  getUser(){
    return this.http.post('http://localhost:8083/login' ,{
        'username': this.username,
        'password': this.password
    });
  }
}