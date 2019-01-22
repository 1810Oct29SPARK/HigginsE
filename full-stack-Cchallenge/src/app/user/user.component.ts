import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: any;
  
  constructor(private dataService: DataService, private router: Router) {}

  logout() {
    this.dataService.setUser(null);
    this.router.navigateByUrl('/')
  }

  ngOnInit() {
    this.users = this.dataService.getUser;
    if(this.users == null) {
      this.router.navigateByUrl('/');
    }
  }
}
