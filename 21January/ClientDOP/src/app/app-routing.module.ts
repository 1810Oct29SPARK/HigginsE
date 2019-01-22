import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './login/signin/signin.component';
import { ManagerHomeComponent } from './manager-home/manager-home.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {
    path: 'login', component: LoginComponent,
  },
  { path: 'home', component: HomeComponent },
  { path: 'manager-home', component: ManagerHomeComponent },
  { path: 'signin', component: SigninComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
