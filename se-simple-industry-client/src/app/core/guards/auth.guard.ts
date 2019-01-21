import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivateChild,
  CanLoad,
  Route,
  Router
} from '@angular/router';

import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanActivateChild, CanLoad {

  constructor(
    public router: Router,
    public authService: AuthService
  ) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if (state.url.includes('member')) {
      if (this.authService.currentUserRole === 2) {
        return true;
      } else {
        this.router.navigate(['/login']);
        return false;
      }
    } else if (state.url.includes('admin')) {
      if (this.authService.currentUserRole === 1) {
        return true;
      } else {
        this.router.navigate(['/login']);
        return false;
      }
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }

  canActivateChild(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    return this.canActivate(next, state);
  }

  canLoad(route: Route): boolean {
    if (route.path.includes('member')) {
      if (this.authService.currentUserRole === 2) {
        return true;
      } else {
        this.router.navigate(['/login']);
        return false;
      }
    } else if (route.path.includes('admin')) {
      if (this.authService.currentUserRole === 1) {
        return true;
      } else {
        this.router.navigate(['/login']);
        return false;
      }
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }

}
