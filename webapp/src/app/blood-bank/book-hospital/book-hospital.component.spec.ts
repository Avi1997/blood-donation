import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookHospitalComponent } from './book-hospital.component';

describe('BookHospitalComponent', () => {
  let component: BookHospitalComponent;
  let fixture: ComponentFixture<BookHospitalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookHospitalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookHospitalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
