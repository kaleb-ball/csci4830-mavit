import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MustMatch } from 'src/app/helpers/MustMatch';
import { SignupRequest } from 'src/app/payloads/requests/signup-request';
import { MessageResponse } from 'src/app/payloads/responses/message-response';
import { AuthService } from 'src/app/services/auth-service';
import { first, map } from 'rxjs/operators';
import { College } from 'src/app/models/college';
import { CommonService } from 'src/app/services/common.service';
import { MustSelect } from 'src/app/helpers/MustSelect';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor( 
    private formBuilder : FormBuilder,
    private router : Router,
    private authService : AuthService,
    private commonService : CommonService
  ) { }

  signupForm : FormGroup;
  submitted : boolean = false;
  error : string = '';
  message : string; 
  college1 : boolean = true;
  college2 : boolean = true;
  colleges = [];
  majors1 = [];
  majors2 = [];

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      firstname: ['', [Validators.required, Validators.maxLength(50)]],
      lastname: ['', [Validators.required, Validators.maxLength(50)]],
      email: ['', [Validators.required, Validators.maxLength(50),Validators.email]],
      username: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      passwordConfirm : ['', [Validators.required,Validators.minLength(6), Validators.maxLength(20)]],
      studentId: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
      confirmStudentId : ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
      //major1: [{value : 'Choose...', disabled: true }],
      major2: [{value : 'Choose...', disabled: true }],
      college1:['Choose...'],
      //college2:['Choose...']


    }, {
      validators : [
        MustMatch('password', 'passwordConfirm'), 
        MustMatch('studentId', 'confirmStudentId'), 
        MustSelect('major1'),
        MustSelect('college1')
      ]
    });

    this.commonService.getAllColleges().subscribe((data : any)=>{
      this.colleges = data.sort(function(a,b){return a.name < b.name ? -1 : (a.name > b.name ? 1 : 0)});
    });

  }

  get f() { 
    return this.signupForm.controls; 
  }

  college1Select(value : String) {
    this.signupForm.get('major1').enable()
    this.commonService.getMajorsForCollege(this.colleges[Number(value.substr(0, value.indexOf(':'))) - 1].code).subscribe((data : any) => {
      this.majors1 = data.sort(function(a,b){return a.name < b.name ? -1 : (a.name > b.name ? 1 : 0)});
    })
  }

  college2Select(value : String) {
    this.signupForm.get('major2').enable()
    this.commonService.getMajorsForCollege(this.colleges[Number(value.substr(0, value.indexOf(':'))) - 1].code).subscribe((data : any) => {
      this.majors2 = data.sort(function(a,b){return a.name < b.name ? -1 : (a.name > b.name ? 1 : 0)});
    })
  }

  onSubmit() {
    this.submitted = true;
    if (this.signupForm.invalid) {
      let test = this.f.studentId
      return;
    }

    let signUpRequest = new SignupRequest();

    signUpRequest.firstname = this.f.firstname.value
    signUpRequest.lastname = this.f.lastname.value
    signUpRequest.username = this.f.username.value
    signUpRequest.password = this.f.password.value
    signUpRequest.email = this.f.email.value
    signUpRequest.studentId = this.f.studentId.value
    signUpRequest.majors.push(this.f.major1.value)
    //this.f.major2.value !== 'Choose...' ? signUpRequest.majors.push(this.f.major2.value) : null
    signUpRequest.colleges.push(this.f.college1.value)
    //this.f.major2.value !== 'Choose...' ? signUpRequest.colleges.push(this.f.college2.value) : null

    this.authService.signup(signUpRequest).pipe(first()).subscribe({
      next : next =>  {
        this.router.navigate(['/login'])
      },
      error : error => {
        this.error = error;
      }

    })

  }

}
