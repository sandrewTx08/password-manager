import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { LoginsService } from '../logins.service';

@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css'],
})
export class LoginsComponent implements OnInit {
  constructor(
    private userService: UserService,
    public loginsService: LoginsService
  ) {}

  public ngOnInit(): void {
    this.userService.getUserDetails();
    this.loginsService.findManyLogins();
  }
}
