import { Component, Input, OnInit } from '@angular/core';
import { Login, LoginsService } from '../logins.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-tab-login-form',
  templateUrl: './tab-login-form.component.html',
  styleUrls: ['./tab-login-form.component.css'],
})
export class TabLoginFormComponent implements OnInit {
  @Input()
  public login: Login = Object();
  public formGroup: FormGroup = Object();

  public showPassword: boolean = false;
  public editing: boolean = false;

  constructor(private loginsService: LoginsService) {}

  public ngOnInit(): void {
    this.formGroup = new FormGroup({
      username: new FormControl(this.login.username),
      password: new FormControl(this.login.password),
    });
  }

  public change() {
    this.loginsService.updateLogin(this.formGroup.value);
  }

  public showPasswordClick() {
    this.showPassword = !this.showPassword;
  }

  public editingClick() {
    this.editing = !this.editing;
  }

  public deleteLogin() {
    this.loginsService.deleteLogin(this.login);
  }
}
