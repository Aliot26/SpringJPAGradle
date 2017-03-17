import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {User} from "../model/user";
import 'rxjs/add/operator/map';
import {Observable} from "rxjs/Rx";

@Injectable()
export class AuthenticationService {
    public token: string;
    private currentUser: User;

    constructor(private http: Http) {
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.token = currentUser && currentUser.token;
    }

    login(user: User) : Observable<boolean> {
        let body = JSON.stringify({login: user.login, password: user.password});
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post('/login', body, options)
            .map((response:Response) => {
                let token = response.json() && response.json().token;
                if (token) {
                    this.currentUser = user;
                    this.currentUser.token = token;
                    this.currentUser.roles = ['ROLE_ADMIN', 'ROLE_PERSON'];
                    alert('Welcome, ' + this.currentUser.login);
                    localStorage.setItem('currentUser', JSON.stringify(this.currentUser));
                    return true;
                } else {
                    return false;
                }
            });
    }

    logout(): void {
        this.token = null;
        localStorage.removeItem('currentUser');
    }

    get userRoles() : Array<string> {
        const user = JSON.parse(localStorage.getItem('currentUser'));
        return user ? user.roles : [];
    }
}