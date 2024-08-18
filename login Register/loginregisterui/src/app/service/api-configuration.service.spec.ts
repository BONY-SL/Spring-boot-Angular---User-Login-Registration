import { TestBed } from '@angular/core/testing';

import { ApiConfigurationService } from './api-configuration.service';

describe('ApiConfigurationService', () => {
  let service: ApiConfigurationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiConfigurationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
