import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserModelService {
  public userid: number;
  public firstname: string;
  public lastname: string;
  public email: string;
  public password: string;
  public userRole: number;

  constructor(userid: number, firstname: string, lastname: string, email: string, password: string, userRole: number) {
    this.userid = userid;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.userRole = userRole;
  }
}
