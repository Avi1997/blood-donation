import { TestBed } from '@angular/core/testing';

import { BloodDonationService } from './blood-donation.service';

describe('BloodDonationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BloodDonationService = TestBed.get(BloodDonationService);
    expect(service).toBeTruthy();
  });
});
