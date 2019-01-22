import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private HttpClient: HttpClient) { }

  signIn(email: string) {
    this.HttpClient.post('', {'email': email});
    //
  }
}
