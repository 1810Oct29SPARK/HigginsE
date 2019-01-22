import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  users: any;

  setUser(users) {
    this.users = users;
  }

  getUser(users) {
    return this.users = users;
  }

  constructor() { }
}
