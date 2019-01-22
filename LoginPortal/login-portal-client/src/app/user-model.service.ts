import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserModelService {

  public id: number;
  public name: string;
  public email: any;
  public username: string;

  constructor(id: number, name: string, email: any, username: string) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.username = username;
   }

}
