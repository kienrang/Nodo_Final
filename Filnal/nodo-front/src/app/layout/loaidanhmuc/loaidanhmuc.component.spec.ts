import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoaidanhmucComponent } from './loaidanhmuc.component';

describe('LoaidanhmucComponent', () => {
  let component: LoaidanhmucComponent;
  let fixture: ComponentFixture<LoaidanhmucComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoaidanhmucComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoaidanhmucComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
