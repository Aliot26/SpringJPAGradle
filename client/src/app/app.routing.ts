import {Routes, RouterModule} from '@angular/router';
import {NotFoundComponent} from "./users/not-found.component";

import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";

const appRoutes:Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    //{path: 'register', component: RegisterComponent},
    {path: '**', component: NotFoundComponent}
];

export const routing = RouterModule.forRoot(appRoutes);