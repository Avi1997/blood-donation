import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodDonationService } from '../blood-donation.service';
import { BloodAvailablityPojo } from '../BloodAvailablityPojo';
import { AuthenticateService } from 'src/app/site/authenticate.service';
import { NotificationService } from '../notification.service';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  bloodAvailable:Array<BloodAvailablityPojo>[];
  noRequirementFlag:boolean =false;
  constructor(private router:Router,private bloodService:BloodDonationService,private authentication:AuthenticateService,private notificationService:NotificationService) { }

  ngOnInit() {
    this.bloodService.getAllBloodRequirement().subscribe((response:Array<BloodAvailablityPojo>[])=>{
      this.bloodAvailable =response;
      if(this.authentication.islogin() && this.authentication.getLogedInUser() != 'admin')
      this.notificationService.getThreeMonth(this.authentication.getLogedInUser()).subscribe((response)=>{
     
      });
    },error=>{
      this.noRequirementFlag=true;
    })
  }
  isLogin(){
    return this.authentication.islogin();
  }
  logedInUser(){
    return this.authentication.getLogedInUser();
  }
  
  goTips(){
    this.router.navigate(['tips']);
  }
}
