import { TestBed } from '@angular/core/testing';

import { LoaidanhmucService } from './loaidanhmuc.service';

describe('LoaidanhmucService', () => {
  let service: LoaidanhmucService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoaidanhmucService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
