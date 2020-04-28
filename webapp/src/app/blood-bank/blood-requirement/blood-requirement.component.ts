import { Component, OnInit } from '@angular/core';
import { State } from 'src/app/State';
import { BloodAvailablityPojo } from '../BloodAvailablityPojo';
import { BloodDonationService } from '../blood-donation.service';
import { Router } from '@angular/router';
import { FormService } from 'src/app/form.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-blood-requirement',
  templateUrl: './blood-requirement.component.html',
  styleUrls: ['./blood-requirement.component.css']
})
export class BloodRequirementComponent implements OnInit {


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
  areaEmpty: boolean;
  areaClick: boolean;
  stateSelect: boolean;
  constructor(private bloodDonationService: BloodDonationService, private router: Router, private formService: FormService) {
    this.areaEmpty = false;
    this.areaClick = false;
    this.cities = [];
  }

  ngOnInit() {
    this.states = this.formService.getStates();
    this.hospitalForm = new FormGroup({
      'pincode': new FormControl("", [Validators.required, Validators.minLength(6), Validators.maxLength(6)]),
      'mobileNumber': new FormControl("", [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
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
  lengthOfMobile(value) {
    this.mobileCharacterflag = isNaN(Number(this.hospitalForm.value.mobileNumber));
    if (this.hospitalForm.value.mobileNumber.length == value) {
      this.mobileLengthFlag = true;
    } else {
      this.mobileLengthFlag = false;
    }
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
    this.areaEmpty = true;
    this.areaClick = true;
    this.hospitalForm.value.cities.city = "";
    this.stateSelect = false;
  }
  postRequirement(hospitalForm) {
    if (hospitalForm.valid && this.pincodeFlag && this.mobileLengthFlag && !this.mobileCharacterflag) {
      this.bloodDonationService.postBloodRequirement(hospitalForm.value).subscribe((response: BloodAvailablityPojo) => {
        this.sucessFlag = true;
      }, (error => {
        this.allWarning = true;
      }
      ));
    } else {
      this.allWarning = true;
    }
  }

  areaClickFunction(value) {
    if (this.cities.length == 0) {
      this.stateSelect = true;
    } else {
      this.stateSelect = false;
    }
    if (value == "") {
      this.areaEmpty = true;
      this.areaClick = true;
    } else {
      this.areaEmpty = false;
      this.areaClick = false;
    }
  }
}
