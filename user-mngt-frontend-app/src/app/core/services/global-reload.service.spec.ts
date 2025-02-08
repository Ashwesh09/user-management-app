import { TestBed } from '@angular/core/testing';

import { GlobalReloadService } from './global-reload.service';

describe('GlobalReloadService', () => {
  let service: GlobalReloadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GlobalReloadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
