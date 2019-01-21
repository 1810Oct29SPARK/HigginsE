export class UserRole {
    id: number;
    role: string;

  }




export class User {
    id: number;
    name: string;
    password: string;
    email: string;
    userRole: UserRole;

  }