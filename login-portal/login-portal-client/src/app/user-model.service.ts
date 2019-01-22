import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserModelService {

  public id: number;
  public name: string;
  public email: any;

  constructor(id: number, name: string, email: any) {
    this.id = id;
    this.name = name;
    this.email = email;
   }
   
}
