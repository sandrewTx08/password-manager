import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginsComponent } from './logins/logins.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { CreateLoginFormComponent } from './create-login-form/create-login-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TabLoginFormComponent } from './tab-login-form/tab-login-form.component';
import { LoginsFilterPipe } from './logins-filter.pipe';
import { CopyClipboardDirective } from './copy-clipboard.directive';

@NgModule({
  declarations: [
    AppComponent,
    LoginsComponent,
    NavbarComponent,
    CreateLoginFormComponent,
    TabLoginFormComponent,
    LoginsFilterPipe,
    CopyClipboardDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BsDropdownModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
