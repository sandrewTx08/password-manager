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
    return this.http
      .patch<Login>(`logins/${login._id}`, login)
      .subscribe((data) => {
        const index = this.logins.findIndex((value) => value._id == data._id);
        this.logins[index].password = data.password;
        this.logins[index].username = data.username;
      });
  }

  public deleteLogin(login: Login) {
    return this.http.delete<void>(`logins/${login._id}`).subscribe(() => {
      this.logins = this.logins.filter((value) => value._id != login._id);
    });
  }
}
