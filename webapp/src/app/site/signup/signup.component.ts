import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { User } from '../User';
import { FormService } from 'src/app/form.service';
import { State } from 'src/app/State';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  gender: any[];
  bloodGroups: any[];
  stateList: Array<State>;
  stateClick: boolean = false;
  stateEmpty: boolean = true;
  bloodGroupEmpty: boolean = true;
  cities: Array<string>;
  signupForm: FormGroup;
  user: User;
  checkClick: boolean = false;
  checkpass: boolean = false;
  userPresent: boolean = false;
  successMsg: boolean;
  areaEmpty: boolean;
  areaClick: boolean;
  stateSelect: boolean;

  constructor(private userService: UserService, private router: Router, private formService: FormService) {
    this.areaEmpty = false;
    this.areaClick = false;
    this.cities = [];
  }

  ngOnInit() {
    this.stateList = this.formService.getStates();
    this.bloodGroups = this.formService.getBloodGroups();
    this.gender = this.formService.getGenders();
    this.user = {
      username: "",
      firstname: "",
      lastname: "",
      age: 0,
      gender: "",
      contactNo: 0,
      email: "",
      password: "",
      weight: 0,
      state: "",
      area: "",
      pinCode: 0,
      bloodGroup: "",
      confirmPassword: ""
    }

    this.signupForm = new FormGroup({
      userName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(15)]),
      firstName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      password: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(15)]),
      confirmPassword: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.maxLength(2)]),
      genderDivision: new FormGroup({
        gender: new FormControl('')
      }),
      contactNo: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      emailId: new FormControl('', [Validators.required, Validators.email]),
      weight: new FormControl('', [Validators.required]),
      bloodGroupDivision: new FormGroup({
        bloodGroup: new FormControl('')
      }),
      stateDivision: new FormGroup({
        state: new FormControl('')
      }),
      areaDivision: new FormGroup({
        area: new FormControl('')
      }),
      pincode: new FormControl('', Validators.required)
    });
    this.successMsg = false;
  }
  changeCountry(state) {
    this.cities = this.formService.getCities(state);
    this.areaEmpty = true;
    this.areaClick = true;
    this.signupForm.value.areaDivision.area = "";
    this.stateSelect = false;
  }
  checkIfMatchingPasswords() {
    if (this.signupForm.value.password == this.signupForm.value.confirmPassword) {
      this.checkpass = true;
    } else {
      this.checkpass = false;
    }
  }
  changeValue() {
    this.userPresent = false;
  }

  bloodGroupCheck(value) {
    if (value != '') {
      this.bloodGroupEmpty = false;
    } else {
      this.bloodGroupEmpty = true;
    }
    this.checkClick = true;
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
    }
  }
  userAdd(signupForm) {
    this.user.username = signupForm.value.userName;
    this.user.firstname = signupForm.value.firstName;
    this.user.lastname = signupForm.value.lastName;
    this.user.password = signupForm.value.password;
    this.user.confirmPassword = signupForm.value.confirmPassword;
    this.user.age = signupForm.value.age;
    this.user.gender = signupForm.value.genderDivision.gender;
    this.user.contactNo = signupForm.value.contactNo;
    this.user.email = signupForm.value.emailId;
    this.user.weight = signupForm.value.weight;
    this.user.bloodGroup = signupForm.value.bloodGroupDivision.bloodGroup;
    this.user.state = signupForm.value.stateDivision.state;
    this.user.area = signupForm.value.areaDivision.area;
    this.user.pinCode = signupForm.value.pincode;

    this.userService.createUser(this.user).subscribe(response => {
      this.successMsg = true;
    }, (error) => {
      this.userPresent = true
    })
  }
}
