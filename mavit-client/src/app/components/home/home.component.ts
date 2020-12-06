import { Component, OnInit } from '@angular/core';
import { College } from 'src/app/models/college';
import { Major } from 'src/app/models/major';
import { University } from 'src/app/models/university';
import { HomePageResponse } from 'src/app/payloads/responses/HomePageResponse';
import { AuthService } from 'src/app/services/auth-service';
import { HomeService } from 'src/app/services/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(
    private homeService : HomeService,
    private authService : AuthService
  ) { }

  username : String;
  universities : University[] = [];
  colleges : College[] = [];
  majors : Major[] = []

  ngOnInit(): void {
    this.username = this.authService.currentUserValue.username
    this.homeService.getHomeConfig(this.username).subscribe((data : HomePageResponse)=> {
      this.universities = data.universities;
      this.colleges = data.colleges;
      this.majors = data.majors; 
    })
  }



}
