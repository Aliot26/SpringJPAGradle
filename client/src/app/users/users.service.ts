import {Injectable} from "@angular/core";
import {Users} from './users';
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';


@Injectable()
export class UsersService {
    constructor(private http:Http) {
    };

    getUsers():Promise<Users[]> {
        return this.http.get('users')
            .toPromise()
            .then(responce => responce.json())
            .catch(this.handleError);
    }

    private handleError(error:any):Promise<any> {
        console.error('Error', error);
        return Promise.reject(error.message || error);
    }
}