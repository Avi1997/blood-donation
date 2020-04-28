import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../site/authenticate.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  navbarIcon:string;
  user:string;
  constructor(private authenticateService:AuthenticateService) { }

  ngOnInit() {
    this.navbarIcon = "unfold_more";
   
  }

  dropDownButtonClick(){
    if(this.navbarIcon == "unfold_more"){
    this.navbarIcon = "unfold_less";
    }else{
      this.navbarIcon = "unfold_more";
    }
  }
  logout(){
    this.authenticateService.setLogeInFlag(false);
    this.authenticateService.setLogedInUser("");
  }
  isLogin(){
    this.user = this.authenticateService.getLogedInUser();
    return this.authenticateService.islogin();
  }
  logedInUser(){
    return this.authenticateService.getLogedInUser();
  }
}
