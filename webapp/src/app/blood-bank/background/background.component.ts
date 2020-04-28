import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/site/authenticate.service';

@Component({
  selector: 'app-background',
  templateUrl: './background.component.html',
  styleUrls: ['./background.component.css']
})
export class BackgroundComponent implements OnInit {
  constructor(private authenticateService: AuthenticateService) { }

  ngOnInit() {
  }
  isLogin() {
    return this.authenticateService.islogin();
  }
  logedInUser(){
    return this.authenticateService.getLogedInUser();
  }

}
