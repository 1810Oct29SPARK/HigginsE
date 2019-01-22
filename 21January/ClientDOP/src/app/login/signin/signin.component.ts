import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Route, Router } from '@angular/router';



@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) { }


  user: any;

  ngOnInit() {
  }

  onSignIn(form: NgForm): void {
    const email = form.value.email;
    const password = form.value.password;
    this.auth.signInUser(email, password).subscribe((data) => {
      console.log(data);
      this.user = data;
      if (this.user != null) {
        this.auth.setUser(this.user);

        if (this.user.userRole.roleId > 0) {
          this.router.navigateByUrl('/manager-home');
        } else {
          this.router.navigateByUrl('/home');
        }


      } else {
        this.router.navigateByUrl('');
      }
    });
    console.log(form);
  }

}
