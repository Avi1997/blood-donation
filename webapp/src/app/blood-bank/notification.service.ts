import { Injectable } from '@angular/core';
import { AuthenticateService } from '../site/authenticate.service';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  baseUrl: string;
  constructor(private httpClient: HttpClient, private authenticationService: AuthenticateService) { 
    this.baseUrl = environment.baseUrl;
  }

  getAllNotifications(){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(this.baseUrl+"/blood-service/blood-bank/notification/"+this.authenticationService.getLogedInUser(),httpOption);
  }
  getAllNotificationsHistory(){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(this.baseUrl+"/blood-service/blood-bank/notification-history/"+this.authenticationService.getLogedInUser(),httpOption);
  }
  markAsRead(notificationId){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.put(this.baseUrl+"/blood-service/blood-bank/update-notification/"+notificationId,null,httpOption);
  }
  deleteNotification(id){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.delete(this.baseUrl+"/blood-service/blood-bank/delete-notification-history/"+id,httpOption);
  }
  getThreeMonth(username){ 
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post(this.baseUrl+"/blood-service/blood-bank/three-month-notification/"+username,null,httpOption);
  }
  sendRequestToAll(bloodGroup){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post(this.baseUrl+"/blood-service/blood-bank/user-notification-with-bloodgroup/"+bloodGroup,null,httpOption);
  }
}
