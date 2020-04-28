import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticateService } from '../site/authenticate.service';
import { DonorExperiencePojo } from './DonorExperiencePojo';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HospitalFeedbackService {
  baseUrl:string;
  
  constructor(private httpClient: HttpClient, private authService: AuthenticateService) {
    this.baseUrl = environment.baseUrl;
   }

  getAllUserExperience() {
    let httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json'
      })
    };
    return this.httpClient.get(this.baseUrl+"/blood-service/blood-bank/get-feedback", httpOption);
  }

  postUserExperience(donorExperience: DonorExperiencePojo) {
    let httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': 'Bearer ' + this.authService.getToken()
      })
    };
    return this.httpClient.post(this.baseUrl+"/blood-service/blood-bank/put-feedback", donorExperience, httpOption);
  }
}
