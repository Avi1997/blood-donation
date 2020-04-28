import { Component, OnInit } from '@angular/core';
import { Faq } from 'src/app/Faq';
import { BloodDonationService } from '../blood-donation.service';
import { AuthenticateService } from 'src/app/site/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  anonymousFaqs: Faq[];
  userFaq: Faq[];
  question: string;
  successMsg: boolean;
  answerVariable: string;
  answerPosted: boolean;
  emptyFlag: boolean;
  emptyUserFlag:boolean;
  questionLength:boolean;

  constructor(private bloodService: BloodDonationService, private authenticationservice: AuthenticateService, private router: Router) {
    this.userFaq = [];
    this.question = "";
    this.successMsg = false;
    this.answerPosted = false;
    this.emptyFlag = false;
    this.emptyUserFlag =false;
    this.questionLength = false;
  }

  ngOnInit() {
    this.bloodService.getAllFaq().subscribe((response: Faq[]) => {
      this.anonymousFaqs = response;
      if (this.anonymousFaqs.length == 0) {
        this.emptyFlag = true;
      } else {
        this.emptyFlag = false;
      }
      if (this.authenticationservice.islogin()) {
        this.userFaq = this.anonymousFaqs.filter((faq: Faq) => (faq.user == this.authenticationservice.getLogedInUser()));
        console.log(this.userFaq.length);
        if (this.userFaq.length == 0) {
          this.emptyUserFlag = true;
        } else {
          this.emptyUserFlag = false;
        }
      }
    })
  }
  
  successFalse() {
    this.successMsg = false;
    this.router.navigate(['/faq']);
  }
  
  adminFalse() {
    this.answerPosted = false;
    this.router.navigate(['/faq']);
  }
  
  getQuestion(event) {
    this.question = event.target.value;
    if(this.question.length > 6){
      this.questionLength =false;
    }else{
      this.questionLength = true;
    }

  }
  
  postFaq() {
    let faq: Faq = {
      faqId: null,
      user: this.authenticationservice.getLogedInUser(),
      question: this.question,
      answer: null
    }
    if(!this.questionLength && this.question.length!=0){
    this.bloodService.addFaq(faq).subscribe((response) => {
      this.successMsg = true;
    })
  }else{
    this.questionLength =true;
  }
  }
  
  answerFaq(faq) {
    faq.answer = this.answerVariable;
    this.anonymousFaqs = this.anonymousFaqs.filter((demo: Faq) => demo.faqId != faq.faqId);
    if (this.anonymousFaqs.length == 0) {
      this.emptyFlag = true;
    } else {
      this.emptyFlag = false;
    }
    this.bloodService.answerFaq(faq).subscribe((response) => {
      this.answerPosted = true;
    });
  }
  
  answer(event) {
    this.answerVariable = event.target.value;
  }
  islogin() {
    return this.authenticationservice.islogin();
  }
  logedinUser() {
    return this.authenticationservice.getLogedInUser();
  }

}
