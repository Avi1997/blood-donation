import { Component, OnInit } from '@angular/core';
import { State } from 'src/app/State';
import { BloodDonationService } from '../blood-donation.service';
import { Router } from '@angular/router';
import { FormService } from 'src/app/form.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BloodAvailablityPojo } from '../BloodAvailablityPojo';

@Component({
  selector: 'app-search-blood',
  templateUrl: './search-blood.component.html',
  styleUrls: ['./search-blood.component.css']
})
export class SearchBloodComponent implements OnInit {
  sucessFlag: boolean = false;
  bloodGroups: string[];
  hospitalForm: any;
  states: State[];
  cities: Array<any>;
  mobileLengthFlag: boolean;
  pincodeFlag: boolean;
  allWarning: boolean;
  mobileCharacterflag: boolean;
  bloodAvailability: BloodAvailablityPojo;
  show: string;
  constructor(private bloodDonationService: BloodDonationService, private formService: FormService) { }

  ngOnInit() {
    this.states = this.formService.getStates();
    this.hospitalForm = new FormGroup({
      'pincode': new FormControl("", [Validators.required, Validators.minLength(6), Validators.maxLength(6)]),
      'bloodGroups': new FormGroup({
        'bloodGroup': new FormControl("", Validators.required),
      }),
      'states': new FormGroup({
        'state': new FormControl("", Validators.required),
      }),
      'cities': new FormGroup({
        'city': new FormControl("", Validators.required),
      })
    });
    this.bloodGroups = this.formService.getBloodGroups();
    this.mobileLengthFlag = false;
    this.pincodeFlag = false;
    this.allWarning = false;
  }

  lengthOfPincode() {
    if (this.hospitalForm.value.pincode > 99999 && this.hospitalForm.value.pincode < 1000000) {
      this.pincodeFlag = true;
    } else {
      this.pincodeFlag = false;
    }
  }
  changeCountry(state) {
    this.cities = this.formService.getCities(state);
  }
  searchBlood(hospitalForm) {
    if (hospitalForm.valid && this.pincodeFlag) {
      this.bloodDonationService.searchBloodGroup(hospitalForm.value).subscribe((response: BloodAvailablityPojo) => {
        this.bloodAvailability = response;
        this.show = "table";
      }, (error => {
        this.show = "request";
      }
      ));
    } else {
      this.allWarning = true;
    }
  }
}
