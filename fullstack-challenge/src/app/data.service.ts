import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  user: any;

  setUser(user) {
    this.user = user;
  }

  getUser() {
    return this.user;
  }

  constructor() { }
}
