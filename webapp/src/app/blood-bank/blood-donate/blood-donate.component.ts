import { Component, OnInit } from '@angular/core';
import { BloodDonationService } from '../blood-donation.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { State } from 'src/app/State';
import { FormService } from 'src/app/form.service';

@Component({
  selector: 'app-blood-donate',
  templateUrl: './blood-donate.component.html',
  styleUrls: ['./blood-donate.component.css']
})
export class BloodDonateComponent implements OnInit {
  sucessFlag: boolean;
  bloodGroups: string[];
  hospitalForm: FormGroup;
  states: State[];
  cities: Array<string>;
  mobileLengthFlag: boolean;
  pincodeFlag: boolean;
  allWarning: boolean;
  mobileCharacterflag: boolean;
  areaEmpty: boolean;
  areaClick: boolean;
  stateSelect: boolean;
  constructor(private router: Router, private formService: FormService) {
    this.areaEmpty = false;
    this.areaClick = false;
    this.cities = [];
    this.sucessFlag = false;
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
  addDoanerInfo(hospitalForm) {
    if (hospitalForm.valid && this.pincodeFlag && this.mobileLengthFlag && !this.mobileCharacterflag && !this.areaClick && !this.areaEmpty) {
      this.router.navigate(['/hospital-book', hospitalForm.value.bloodGroups.bloodGroup,
        hospitalForm.value.states.state, hospitalForm.value.cities.city, hospitalForm.value.pincode, hospitalForm.value.mobileNumber]);
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
