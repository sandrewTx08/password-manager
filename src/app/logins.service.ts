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

  public constructor(private http: HttpClient) {}

  public findAllUserLogins(): void {
    this.http.get<Login[]>('logins').subscribe((data) => {
      this.logins = data;
    });
  }

  public createLogin(login: Login): void {
    this.http.post<Login>('logins', login).subscribe((data) => {
      this.logins.push(data);
    });
  }

  public updateLogin(login: Login): void {
    const index = this.logins.findIndex((value) => value._id == login._id);
    this.logins[index].password = login.password;
    this.logins[index].username = login.username;

    this.http.patch<Login>('logins', login).subscribe();
  }

  public deleteLogin(login: Login): void {
    this.logins = this.logins.filter((value) => value._id != login._id);

    this.http.delete<void>('logins', { body: login }).subscribe();
  }
}
