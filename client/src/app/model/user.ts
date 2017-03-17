export class User {
    login: string;
    password: string;
    token: string;
    roles: string[];

    constructor(login: string, password: string) {
        this.login = login;
        this.password = password;
    }
}