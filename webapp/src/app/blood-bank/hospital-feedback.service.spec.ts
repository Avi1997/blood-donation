import { TestBed } from '@angular/core/testing';

import { HospitalFeedbackService } from './hospital-feedback.service';

describe('HospitalFeedbackService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HospitalFeedbackService = TestBed.get(HospitalFeedbackService);
    expect(service).toBeTruthy();
  });
});
