import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonateTipsComponent } from './donate-tips.component';

describe('DonateTipsComponent', () => {
  let component: DonateTipsComponent;
  let fixture: ComponentFixture<DonateTipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonateTipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonateTipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
