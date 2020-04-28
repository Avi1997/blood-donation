import { Component, OnInit } from '@angular/core';
import { NotificationPojo } from '../NotificationPojo';
import { NotificationService } from '../notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {
  notificationFlag:boolean;
  notifications:NotificationPojo[];
  emptyNotification:boolean;
  notificationsHistory:NotificationPojo[];
  emptyNotificationHistory:boolean;
  constructor(private notificationService:NotificationService) {
    this.emptyNotification = false;
    this.emptyNotificationHistory =false;
   }

  ngOnInit() {
    this.notificationService.getAllNotifications().subscribe((response:NotificationPojo[])=>{
      this.notifications = response;
      if(this.notifications.length == 0){
        this.emptyNotification=true;
      }else{
        this.emptyNotification=false;
      }
    })
  }

  flagTrue(){
    this.notificationFlag = !this.notificationFlag;
  }
  flagtruesecond(){
    this.getHistory();
    this.notificationFlag = !this.notificationFlag;
  }
  getHistory(){
    this.notificationService.getAllNotificationsHistory().subscribe((response:NotificationPojo[])=>{
      this.notificationsHistory = response;
      if(this.notificationsHistory.length == 0){
        this.emptyNotificationHistory=true;
      }else{
        this.emptyNotificationHistory=false;
      }   
    });
  }
  markAsRead(notification){
    this.notificationService.markAsRead(notification.id).subscribe((response)=>{
      this.notifications = this.notifications.filter((test:NotificationPojo)=> (test.id != notification.id));
      if(this.notifications.length == 0){
        this.emptyNotification=true;
      }else{
        this.emptyNotification=false;
      }
    });
  }
  removeNotification(history){
    this.notificationService.deleteNotification(history.id).subscribe((response)=>{
      this.notificationsHistory = this.notificationsHistory.filter((test:NotificationPojo)=>(test.id!=history.id));
      if(this.notificationsHistory.length == 0){
        this.emptyNotificationHistory=true;
      }else{
        this.emptyNotificationHistory=false;
      }   
    })
  }

}
