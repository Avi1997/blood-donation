import { Component, OnInit } from '@angular/core';
import { BloodCount } from '../BloodCount';
import { BloodDonationService } from '../blood-donation.service';
import { NotificationService } from '../notification.service';
import { AuthenticateService } from 'src/app/site/authenticate.service';

@Component({
  selector: 'app-blood-count',
  templateUrl: './blood-count.component.html',
  styleUrls: ['./blood-count.component.css']
})
export class BloodCountComponent implements OnInit {
  bloodinformation:BloodCount[];
  notificationSentFlag:string;
  constructor(private bloodService:BloodDonationService,private notification:NotificationService,private authenticationService:AuthenticateService) { 
    this.notificationSentFlag ="";
  }

  ngOnInit() {
    if(this.authenticationService.islogin() && this.authenticationService.getLogedInUser() =="admin"){
    this.bloodService.getAllCount().subscribe((response:BloodCount[])=>{
      this.bloodinformation = response;
    })
  }
  }
  sendNotification(bloodGroup){
    this.notification.sendRequestToAll(bloodGroup).subscribe((response)=>{
      this.notificationSentFlag = bloodGroup;
    })
  }
}
