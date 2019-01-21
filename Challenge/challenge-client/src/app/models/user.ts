export class User {
    id: number;
    name: string;
    password: string;
    email: string;
    userRole: number;

    constructor(id: number, name: string, password: string, email: string, userRole: number){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }
}