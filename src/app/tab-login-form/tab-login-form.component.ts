import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
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

  @Output()
  public deletion: EventEmitter<void> = new EventEmitter<void>();

  public formGroup: FormGroup = Object();

  public showPassword: boolean = false;
  public editing: boolean = false;

  public constructor(private loginsService: LoginsService) {}

  public ngOnInit(): void {
    this.formGroup = new FormGroup({
      username: new FormControl(this.login.username),
      password: new FormControl(this.login.password),
    });
  }

  public change(): void {
    this.loginsService.updateLogin({ ...this.login, ...this.formGroup.value });
  }

  public deleteLogin(): void {
    this.loginsService.deleteLogin(this.login);
  }
}
