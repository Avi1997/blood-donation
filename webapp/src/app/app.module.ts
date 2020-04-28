import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BackgroundComponent } from './blood-bank/background/background.component';
import { InfoComponent } from './blood-bank/info/info.component';
import { HttpClientModule } from '@angular/common/http';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BookHospitalComponent } from './blood-bank/book-hospital/book-hospital.component';
import { DonateTipsComponent } from './blood-bank/donate-tips/donate-tips.component';
import { BloodDonateComponent } from './blood-bank/blood-donate/blood-donate.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { SearchBloodComponent } from './blood-bank/search-blood/search-blood.component';
import { BloodRequirementComponent } from './blood-bank/blood-requirement/blood-requirement.component';
import { HospitalFeedbackComponent } from './blood-bank/hospital-feedback/hospital-feedback.component';
import { ShowFeedbackComponent } from './blood-bank/show-feedback/show-feedback.component';
import { FaqComponent } from './blood-bank/faq/faq.component';
import { NotificationComponent } from './blood-bank/notification/notification.component';
import { BloodCountComponent } from './blood-bank/blood-count/blood-count.component';
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    BackgroundComponent,
    InfoComponent,
    BloodDonateComponent,
    BookHospitalComponent,
    DonateTipsComponent,
    SignupComponent,
    LoginComponent,
    SearchBloodComponent,
    BloodRequirementComponent,
    HospitalFeedbackComponent,
    ShowFeedbackComponent,
    FaqComponent,
    NotificationComponent,
    BloodCountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
