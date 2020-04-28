import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BloodDonationService } from '../blood-donation.service';
import { FormService } from 'src/app/form.service';
import { BloodAvailablityPojo } from '../BloodAvailablityPojo';
import { ActivatedRoute } from '@angular/router';
import { SlotBook } from '../SlotBook';

@Component({
  selector: 'app-book-hospital',
  templateUrl: './book-hospital.component.html',
  styleUrls: ['./book-hospital.component.css']
})
export class BookHospitalComponent implements OnInit {
  sucessMsg: boolean;
  hospitalForm: FormGroup;
  timeGroup: string[];
  slotTakenFlag: boolean;
  hospitalNameFlag: boolean;
  cityFlag: boolean;
  doanerInfo: SlotBook;
  constructor(private bloodDonationService: BloodDonationService, private formService: FormService, private actRouter: ActivatedRoute) {
    this.sucessMsg = false;
    this.slotTakenFlag = false;
  }

  ngOnInit() {
    this.hospitalForm = new FormGroup({
      'hospitalName': new FormControl("", [Validators.required, Validators.maxLength(15)]),
      'city': new FormControl("", [Validators.required, Validators.maxLength(15)]),
      'date': new FormControl("", Validators.required),
      'timeGroup': new FormGroup({
        'time': new FormControl(""),
      })
    });
    this.timeGroup = this.formService.getTimeSlot();
    this.hospitalNameFlag = false;
    this.cityFlag = false;

  }
  slotBookedFlag() {
    this.slotTakenFlag = false;
  }
  checkLength(value) {
    if (value.length >= 15) {
      this.hospitalNameFlag = true;
    } else {
      this.hospitalNameFlag = false;
    }
  }
  checkCityLength(value) {
    if (value.length >= 15) {
      this.cityFlag = true;
    } else {
      this.cityFlag = false;
    }
  }
  checkForSlot(hospitalForm) {
    this.doanerInfo = {
      bloodGroup: this.actRouter.snapshot.paramMap.get('bloodGroup'),
      state: this.actRouter.snapshot.paramMap.get('state'),
      area: this.actRouter.snapshot.paramMap.get('city'),
      pinCode: +(this.actRouter.snapshot.paramMap.get('pincode')),
      contactNo: +(this.actRouter.snapshot.paramMap.get('mobileNumber')),
      hospitalName: hospitalForm.value.hospitalName,
      city: hospitalForm.value.city,
      date: hospitalForm.value.date,
      time: hospitalForm.value.timeGroup.time
    };
    if (hospitalForm.valid && !this.hospitalNameFlag && !this.cityFlag) {
      this.bloodDonationService.bookHospitalSlot(this.doanerInfo).subscribe((response) => {
        this.sucessMsg = true;
        this.slotTakenFlag = false;
      }, (error) => {
        this.slotTakenFlag = true;
      })
    } else {
      this.slotTakenFlag = true;
    }
  }
}
