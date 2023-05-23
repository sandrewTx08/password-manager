import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface UserDetails {
  user: {
    _id: string;
    email: string;
  };
}

@Injectable({
  providedIn: 'root',
})
export class UserdetailsService {
  public userDetails: UserDetails = {
    user: {
      _id: String(),
      email: String(),
    },
  };

  constructor(private http: HttpClient) {}

  public setUserDetails() {
    return this.http.get<UserDetails>('userdetails').subscribe((data) => {
      this.userDetails = data;
    });
  }
}
