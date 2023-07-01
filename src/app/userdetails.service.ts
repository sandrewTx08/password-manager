import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface UserDetails {
  email: string;
}

@Injectable({
  providedIn: 'root',
})
export class UserdetailsService {
  public userDetails: UserDetails = { email: '' };

  public constructor(private http: HttpClient) {}

  public setUserDetails(): void {
    this.http.get<UserDetails>('userdetails').subscribe((data) => {
      this.userDetails = data;
    });
  }
}
