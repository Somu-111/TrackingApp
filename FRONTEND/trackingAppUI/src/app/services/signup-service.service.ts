import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupServiceService {

  private baseUrl="http://localhost:3033/signup/";
  constructor(private httpclient:HttpClient) { }

  saveSignup(signupdata:any):Observable<any>{
    return this.httpclient.post(this.baseUrl+"save",signupdata);
  }
}
