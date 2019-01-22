import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserModelService } from './user-model.service';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  httpHeaders = new HttpHeaders ({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
  });


  constructor(private httpClient: HttpClient) {}

  addUser(user) {
    return this.httpClient.post("http://localhost:8080/login-portal/user/add", user, 
    {
      headers: this.httpHeaders,
    }
    )
      .subscribe((res)=>
        console.log(res)
      )
  }

  getUserByUsername(user) {
    return this.httpClient.get<UserModelService>("http://localhost:8080/login-portal/user/byUsername", user)
  }
}
