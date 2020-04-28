import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InfoComponent } from './blood-bank/info/info.component';
import { BookHospitalComponent } from './blood-bank/book-hospital/book-hospital.component';
import { BloodDonateComponent } from './blood-bank/blood-donate/blood-donate.component';
import { DonateTipsComponent } from './blood-bank/donate-tips/donate-tips.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { AuthenticateGuard } from './site/authenticate.guard';
import { SearchBloodComponent } from './blood-bank/search-blood/search-blood.component';
import { BloodRequirementComponent } from './blood-bank/blood-requirement/blood-requirement.component';
import { HospitalFeedbackComponent } from './blood-bank/hospital-feedback/hospital-feedback.component';
import { FaqComponent } from './blood-bank/faq/faq.component';
import { NotificationComponent } from './blood-bank/notification/notification.component';


const routes: Routes = [{path:"",component:InfoComponent},
{path:"blood-donation",component:BloodDonateComponent,canActivate:[AuthenticateGuard]},
{path:"hospital-book/:bloodGroup/:state/:city/:pincode/:mobileNumber", component:BookHospitalComponent,canActivate:[AuthenticateGuard]},
{path:"tips",component:DonateTipsComponent},
{path:"sign-up",component:SignupComponent},
{path:"login",component:LoginComponent},
{path:"login/:info-flag", component:LoginComponent},
{path:"search-blood",component:SearchBloodComponent,canActivate:[AuthenticateGuard]},
{path:"blood-requirement",component:BloodRequirementComponent,canActivate:[AuthenticateGuard]},
{path:"feedback",component:HospitalFeedbackComponent,canActivate:[AuthenticateGuard]},
{path:"faq",component:FaqComponent,canActivate:[AuthenticateGuard]},
{path:"notification",component:NotificationComponent,canActivate:[AuthenticateGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
