import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from "@angular/http";
import {FormsModule}   from '@angular/forms';
import {Routes, RouterModule} from '@angular/router';
import {AppComponent}   from './app.component';
import {GetusersComponent} from "./users/getusers.component";
import {AdduserComponent} from "./users/adduser.component";
import {UsersService} from './users/users.service';
import {HomeComponent} from "./users/home.component";
import {NotFoundComponent} from "./users/not-found.component";

const appRoutes:Routes = [
    {path: '', component: HomeComponent},
    {path: 'users', component: GetusersComponent},
    {path: 'adduser', component: AdduserComponent},
    {path: '**', component: NotFoundComponent}
];


@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes)],
    declarations: [AppComponent, GetusersComponent, AdduserComponent, HomeComponent, NotFoundComponent],
    providers: [UsersService],
    bootstrap: [AppComponent]
})
export class AppModule {
}