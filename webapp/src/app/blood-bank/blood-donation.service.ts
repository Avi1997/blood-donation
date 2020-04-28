import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BloodAvailablityPojo } from './BloodAvailablityPojo';
import { AuthenticateService } from '../site/authenticate.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BloodDonationService {
  baseUrl: string;

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticateService) {
    this.baseUrl = environment.baseUrl;
  }

  saveDoanerInformation(formgroup) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    let bloodAvailablityPojo: BloodAvailablityPojo;
    bloodAvailablityPojo = {
      bloodGroup: formgroup.bloodGroups.bloodGroup,
      state: formgroup.states.state,
      area: formgroup.cities.city,
      pincode: formgroup.pincode,
      contactNumber: formgroup.mobileNumber
    };
    return this.httpClient.post(this.baseUrl + "/blood-service/blood-bank/add-doaner", bloodAvailablityPojo, httpOption);
  }

  bookHospitalSlot(bookSlot) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post(this.baseUrl + "/blood-service/blood-bank/donate/"+this.authenticationService.getLogedInUser(), bookSlot, httpOption);
  }
  searchBloodGroup(bloodSearch) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(this.baseUrl + "/blood-service/blood-bank/" +
      bloodSearch.bloodGroups.bloodGroup + "/" + bloodSearch.states.state + "/" +
      bloodSearch.cities.city + "/" + bloodSearch.pincode, httpOption);
  }

  postBloodRequirement(formgroup) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    let bloodPosting: BloodAvailablityPojo;
    bloodPosting = {
      bloodGroup: formgroup.bloodGroups.bloodGroup,
      state: formgroup.states.state,
      area: formgroup.cities.city,
      pincode: formgroup.pincode,
      contactNumber: formgroup.mobileNumber
    };
    return this.httpClient.post(this.baseUrl + "/blood-service/blood-bank/post-requirement", bloodPosting, httpOption);
  }
  getAllBloodRequirement() {
    return this.httpClient.get(this.baseUrl + "/blood-service/blood-bank/get-requirement");
  }
  getAllFaq() {
    if (this.authenticationService.islogin()) {
      let token = "Bearer " + this.authenticationService.getToken();
      const httpOption = {
        headers: new HttpHeaders({
          'content-type': 'application/json',
          'Authorization': token
        })
      };
      return this.httpClient.get(this.baseUrl + "/blood-service/blood-bank/faq", httpOption);
    }
    return this.httpClient.get(this.baseUrl + "/blood-service/blood-bank/faq");
  }
  addFaq(question) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post(this.baseUrl + "/blood-service/blood-bank/faq", question, httpOption);
  }
  answerFaq(answer) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.put(this.baseUrl + "/blood-service/blood-bank/faq", answer, httpOption);
  }

  getAllCount(){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(this.baseUrl+"/blood-service/blood-bank/blood-count",httpOption);
  }
}
