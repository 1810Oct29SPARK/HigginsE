import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class User {

  id: number;
  username: string;
  password: string;
  role: string;

  constructor() { }
}