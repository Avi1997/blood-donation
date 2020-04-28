import { Injectable } from '@angular/core';
import { User } from './User';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl:string;
  constructor(private httpClient:HttpClient) { 
    this.baseUrl = environment.baseUrl;
  }

  createUser(user) {
    let usernew: User = user;
    return this.httpClient.post(this.baseUrl+"/authentication-service/blood-bank/users", usernew);
  }
}
