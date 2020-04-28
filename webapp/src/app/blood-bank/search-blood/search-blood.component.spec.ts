import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBloodComponent } from './search-blood.component';

describe('SearchBloodComponent', () => {
  let component: SearchBloodComponent;
  let fixture: ComponentFixture<SearchBloodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchBloodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchBloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
