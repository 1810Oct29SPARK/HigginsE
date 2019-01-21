import {Injectable} from "@angular/core";
import { HttpClient, HttpParams } from '@angular/common/http';
import 'rxjs/add/operator/map';
import {User} from "./models/User"; 
import { Observable } from "rxjs";

@Injectable()
export class UserService {
    data:any;
    username:string;
    password:string;
    public user:User;
  constructor(private http: HttpClient) {}

  getUser():Observable<User>{
    return this.http.post<User>('http://localhost:8083/login' ,{
        'username': this.username,
        'password': this.password
    });
  }
}