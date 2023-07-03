import { Component, OnInit } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';
import { Login, LoginsService } from '../logins.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css'],
})
export class LoginsComponent implements OnInit {
  public selected: Login | null = null;

  public loginsFilterSearchInput: FormControl<string | null> =
    new FormControl<string>('');

  public constructor(
    private userDetailsService: UserdetailsService,
    public loginsService: LoginsService
  ) {}

  public ngOnInit(): void {
    this.userDetailsService.setUserDetails();
    this.loginsService.findAllUserLogins();
  }
}
