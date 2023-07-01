import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LoginsService } from '../logins.service';

@Component({
  selector: 'app-create-login-form',
  templateUrl: './create-login-form.component.html',
  styleUrls: ['./create-login-form.component.css'],
})
export class CreateLoginFormComponent {
  public showPassword: boolean = false;

  public formGroup: FormGroup = new FormGroup({
    domain: new FormControl(),
    username: new FormControl(),
    password: new FormControl(),
  });

  public constructor(private loginsService: LoginsService) {}

  public ngSubmit(): void {
    this.loginsService.createLogin(this.formGroup.value);
  }
}
