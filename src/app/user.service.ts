import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface User {
  _id: string;
  email: string;
}

@Injectable({
  providedIn: 'root',
})
export class UserService {
  public user: User = {
    _id: String(),
    email: String(),
  };

  constructor(private http: HttpClient) {}

  public getUserDetails() {
    return this.http.get<User>('userdetails').subscribe((data) => {
      this.user = data;
    });
  }
}
