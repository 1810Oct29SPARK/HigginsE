import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  };
  
  constructor(private http: HttpClient) { }

  getAll(): Observable<Object> {
    return this.http.get("http://localhost:8087/all");
  }

  getAdminOrMember(RoleId): Observable<Object> {
    return this.http.get("http://localhost:8087/byUserRole/"+RoleId.toString());
  }

  getUserByName(Name): Observable<Object> {
    return this.http.get("http://localhost:8087/byName/"+Name.toString());
  }

  addUser(User): Observable<Object> {
    return this.http.post("http://localhost:8087/addUser", User, this.httpOptions);
  }


}
