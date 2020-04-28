import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalFeedbackComponent } from './hospital-feedback.component';

describe('HospitalFeedbackComponent', () => {
  let component: HospitalFeedbackComponent;
  let fixture: ComponentFixture<HospitalFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HospitalFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
