import { Component } from '@angular/core';
import { UserdetailsService } from '../userdetails.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  public constructor(public userDetailsService: UserdetailsService) {}
}
