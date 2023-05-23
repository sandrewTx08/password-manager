import { Component, OnInit } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';
import { LoginsService } from '../logins.service';

@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css'],
})
export class LoginsComponent implements OnInit {
  constructor(
    private userDetailsService: UserdetailsService,
    public loginsService: LoginsService
  ) {}

  public ngOnInit(): void {
    this.userDetailsService.setUserDetails();
    this.loginsService.findManyLogins();
  }
}
