import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabLoginFormComponent } from './tab-login-form.component';

describe('TabLoginFormComponent', () => {
  let component: TabLoginFormComponent;
  let fixture: ComponentFixture<TabLoginFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TabLoginFormComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(TabLoginFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
