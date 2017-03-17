import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from "@angular/http";
import {FormsModule}   from '@angular/forms';
import {routing} from './app.routing';
import {AppComponent}   from './app.component';
import {GetusersComponent} from "./users/getusers.component";
import {AdduserComponent} from "./users/adduser.component";
import {UsersService} from './users/users.service';
import {HomeComponent} from "./home/home.component";
import {NotFoundComponent} from "./users/not-found.component";
import {LoginComponent} from "./login/login.component";
import {AuthenticationService} from "./login/authentication.service";


@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, routing],
    declarations: [AppComponent, GetusersComponent, AdduserComponent, HomeComponent, LoginComponent, NotFoundComponent],
    providers: [UsersService, AuthenticationService],
    bootstrap: [AppComponent]
})
export class AppModule {
}