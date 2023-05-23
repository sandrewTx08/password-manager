import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface Login {
  _id: string;
  domain: string;
  username: string | null;
  password: string;
}

@Injectable({
  providedIn: 'root',
})
export class LoginsService {
  public logins: Login[] = Array();

  constructor(private http: HttpClient) {}

  public findManyLogins() {
    return this.http.get<Login[]>('logins').subscribe((data) => {
      this.logins = data;
    });
  }

  public createLogin(login: Login) {
    return this.http.post<Login>('logins', login).subscribe((data) => {
      this.logins.push(data);
    });
  }

  public updateLogin(login: Login) {
    return this.http.patch<Login>('logins', login).subscribe((data) => {
      this.logins[this.logins.findIndex((value) => value._id === login._id)] =
        data;
    });
  }

  public deleteLogin(login: Login) {
    return this.http.delete<void>(`logins/${login._id}`).subscribe(() => {
      delete this.logins[
        this.logins.findIndex((value) => value._id === login._id)
      ];
    });
  }
}
