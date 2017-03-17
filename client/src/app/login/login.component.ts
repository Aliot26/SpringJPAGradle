import {Component, OnInit} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {AuthenticationService} from "./authentication.service";
import {User} from "../model/user";
import {Router} from "@angular/router";

@Component({
    selector: 'login-component',
    templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
    user:FormGroup;
    loading = false;
    error = '';

    constructor(private router:Router, private authenticationService:AuthenticationService
                ) {
    }

    ngOnInit():void {
        this.user = new FormGroup({
            login: new FormControl('', Validators.required),
            password: new FormControl('', Validators.required)
        });
        this.authenticationService.logout();
    }

    onSubmit() {
        this.login();
    }

    login() {
        this.loading = true;
        this.authenticationService.login(new User(this.user.value.login, this.user.value.password))
            .subscribe(result => {
                if (result === true) {
                    this.router.navigate(['/']);
                } else {
                    this.error = 'Login or password is incorrect';
                    this.loading = false;
                }
            });
    }

}