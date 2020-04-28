import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodRequirementComponent } from './blood-requirement.component';

describe('BloodRequirementComponent', () => {
  let component: BloodRequirementComponent;
  let fixture: ComponentFixture<BloodRequirementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BloodRequirementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodRequirementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
