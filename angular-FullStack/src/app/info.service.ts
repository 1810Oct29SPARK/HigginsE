import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  user: any;

  setUser(user) {
    this.user = user;
  }

  getUser() {
    return this.user;
  }

  constructor() { }
}
