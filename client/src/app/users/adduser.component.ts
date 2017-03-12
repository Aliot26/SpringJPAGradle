import {Component, OnInit} from '@angular/core';
import {UsersService} from './users.service';
import {Users} from './users';

@Component({
    selector: 'add-user',
    templateUrl: 'adduser.component.html'
})
export class AdduserComponent implements OnInit {

    users:Users[] = [];

    constructor(private usersService:UsersService) {
    }

    ngOnInit(): void {
        this.getUsers();
    }

    getUsers(): void{
        this.usersService.getUsers()
            .then(usersFromService => this.users = usersFromService)
    }
}