import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './login/auth.service';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  httpHeaders = new HttpHeaders ({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
  });

  constructor(private httpClient: HttpClient, private authService: AuthService) { }

  
}
