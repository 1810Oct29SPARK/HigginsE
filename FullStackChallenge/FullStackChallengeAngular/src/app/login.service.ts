import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  logIn(username: String, password: String) {
    var end = "http://localhost:8082/HighTechIndustries/login/" + username + "/" + password;
    fetch(end).then(function (response) { return response.json() })
      .then(function (data) {
        sessionStorage.ID = data.id;
        sessionStorage.employeeStatus = data.employeeStatus;
        location.reload()
      });
  }

}
