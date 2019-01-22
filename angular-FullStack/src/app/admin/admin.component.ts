import { Router } from '@angular/router';
import { InfoService } from './../info.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  user: any;
  constructor(private service: InfoService, private router: Router ) { }

  ngOnInit() {
    this.user = this.service.getUser();
    if ( this.user == null) {
      this.router.navigateByUrl('/');
    }
  }
}

