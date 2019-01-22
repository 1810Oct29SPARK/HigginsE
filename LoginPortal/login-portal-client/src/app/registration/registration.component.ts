import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DataServiceService } from '../data-service.service'
import { UserModelService } from '../user-model.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private dataService: DataServiceService) { }

  ngOnInit() {
  }

  onSignUp(form: NgForm) {
    const newUser = new UserModelService(null, form.value.name, form.value.email, form.value.username)
    this.dataService.addUser(newUser);
    console.log(newUser);
  }

}
