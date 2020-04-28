import { Component, OnInit } from '@angular/core';
import { DonorExperiencePojo } from '../DonorExperiencePojo';
import { HospitalFeedbackService } from '../hospital-feedback.service';

@Component({
  selector: 'app-show-feedback',
  templateUrl: './show-feedback.component.html',
  styleUrls: ['./show-feedback.component.css']
})
export class ShowFeedbackComponent implements OnInit {

  userExperience: DonorExperiencePojo[];
  constructor(private userExperienceService: HospitalFeedbackService) { }

  ngOnInit() {
    this.userExperienceService.getAllUserExperience().subscribe((response: DonorExperiencePojo[]) => {
      this.userExperience = response;
    });
  }

}
