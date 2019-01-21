import { UserRole } from './user-role';

export class Appuser {
  appuserId: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  userRole: UserRole;
  jws: string;
}
