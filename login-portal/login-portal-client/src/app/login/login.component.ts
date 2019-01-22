import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private AuthService: AuthServiceService) { }

  
  ngOnInit() {
    
  }

  onSignIn(form: NgForm) {
    const email: any = form.value.email;
    this.AuthService.signIn(email);
  }
}
