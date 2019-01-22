import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-normal-user',
  templateUrl: './normal-user.component.html',
  styleUrls: ['./normal-user.component.css']
})
export class NormalUserComponent implements OnInit {

  user: any;

  constructor(private dataService: DataService, private router: Router) { }

  logout() {
    this.dataService.setUser(null);
    this.router.navigateByUrl('/')
  }

  ngOnInit() {
    this.user = this.dataService.getUser();
    if (this.user == null) {
      this.router.navigateByUrl('/');
    }
  }

}
