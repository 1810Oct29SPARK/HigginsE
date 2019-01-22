import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../data-service.service'
import { UserModelService } from '../user-model.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(private dataService: DataServiceService) { }

  ngOnInit() {
    let user = new UserModelService(1, 'John Doe', 'JohnDoe@gmail.com', 'JohnDoe');
    this.getUserInfo(user);
  }

  getUserInfo(user) {
    let username = user.username;
    this.dataService.getUserByUsername(username)
  }

}
