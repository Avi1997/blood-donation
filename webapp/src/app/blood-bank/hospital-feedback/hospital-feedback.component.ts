import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticateService } from 'src/app/site/authenticate.service';
import { HospitalFeedbackService } from '../hospital-feedback.service';
import { DonorExperiencePojo } from '../DonorExperiencePojo';

@Component({
  selector: 'app-hospital-feedback',
  templateUrl: './hospital-feedback.component.html',
  styleUrls: ['./hospital-feedback.component.css']
})
export class HospitalFeedbackComponent implements OnInit {

  userExperienceForm: FormGroup;
  shareStatus: boolean = false;

  constructor(private authService: AuthenticateService, private donorExperienceService: HospitalFeedbackService) { }

  ngOnInit() {

    this.userExperienceForm = new FormGroup({
      'hospitalName': new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(15)
      ]),
      'city': new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(15)
      ]),
      'feedbackComments': new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(500)
      ])
    });
  }

  share(donorExperience: any) {
    let experience: DonorExperiencePojo = {
      hospitalName: donorExperience.value.hospitalName,
      city: donorExperience.value.city,
      feedbackComments: donorExperience.value.feedbackComments
    };
    this.donorExperienceService.postUserExperience(experience).subscribe(response => {
      this.shareStatus = true;
    })
  }
}
