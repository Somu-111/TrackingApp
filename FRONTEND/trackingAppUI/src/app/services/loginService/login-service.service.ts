import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private baseUrl="http://localhost:3033/login/";

  constructor(private httpClient:HttpClient) { }

  checkLogin(loginData:any):Observable<any>{
    return this.httpClient.post(this.baseUrl+"checkLogin",loginData);
  }
}
