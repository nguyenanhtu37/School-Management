import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutClassComponent } from './out-class.component';

describe('OutClassComponent', () => {
  let component: OutClassComponent;
  let fixture: ComponentFixture<OutClassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OutClassComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OutClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
