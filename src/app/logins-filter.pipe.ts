import { Pipe, PipeTransform } from '@angular/core';
import { Login } from './logins.service';

@Pipe({
  name: 'loginsFilter',
})
export class LoginsFilterPipe implements PipeTransform {
  transform(logins: Login[], search: string | null): Login[] {
    return logins.filter((login) =>
      search ? JSON.stringify(login).includes(search) : true
    );
  }
}
