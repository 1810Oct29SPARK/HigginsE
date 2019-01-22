import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

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
