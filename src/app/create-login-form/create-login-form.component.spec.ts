import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLoginFormComponent } from './create-login-form.component';

describe('CreateLoginFormComponent', () => {
  let component: CreateLoginFormComponent;
  let fixture: ComponentFixture<CreateLoginFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateLoginFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateLoginFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
