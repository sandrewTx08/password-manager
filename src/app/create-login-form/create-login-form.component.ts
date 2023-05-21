import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LoginsService } from '../logins.service';

@Component({
  selector: 'app-create-login-form',
  templateUrl: './create-login-form.component.html',
  styleUrls: ['./create-login-form.component.css'],
})
export class CreateLoginFormComponent {
  public formGroup: FormGroup = new FormGroup({
    domain: new FormControl(),
    username: new FormControl(),
    password: new FormControl(),
  });

  constructor(private loginsService: LoginsService) {}

  public ngSubmit() {
    this.loginsService.createLogin(this.formGroup.value);
  }
}
