import { TestBed } from '@angular/core/testing';

import { RestfulAPIService } from './restful-api.service';

describe('RestfulAPIService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RestfulAPIService = TestBed.get(RestfulAPIService);
    expect(service).toBeTruthy();
  });
});
