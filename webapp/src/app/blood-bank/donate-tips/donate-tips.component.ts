import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-donate-tips',
  templateUrl: './donate-tips.component.html',
  styleUrls: ['./donate-tips.component.css']
})
export class DonateTipsComponent implements OnInit {
  dropIcon: string[];
  constructor() { }

  ngOnInit() {
    this.dropIcon = ["chevron_right", "chevron_right", "chevron_right", "chevron_right", "chevron_right"];
  }
  dropDownValue(value) {
    if (this.dropIcon[0] != "expand_more" && value == 0) {
      this.dropIcon[0] = "expand_more";
    } else {
      this.dropIcon[0] = "chevron_right";
    }
    if (this.dropIcon[1] != "expand_more" && value == 1) {
      this.dropIcon[1] = "expand_more";
    } else {
      this.dropIcon[1] = "chevron_right";
    }
    if (this.dropIcon[2] != "expand_more" && value == 2) {
      this.dropIcon[2] = "expand_more";
    } else {
      this.dropIcon[2] = "chevron_right";
    }
    if (this.dropIcon[3] != "expand_more" && value == 3) {
      this.dropIcon[3] = "expand_more";
    } else {
      this.dropIcon[3] = "chevron_right";
    }
    if (this.dropIcon[4] != "expand_more" && value == 4) {
      this.dropIcon[4] = "expand_more";
    } else {
      this.dropIcon[4] = "chevron_right";
    }
  }

}
