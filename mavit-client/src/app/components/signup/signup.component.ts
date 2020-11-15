import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MustMatch } from 'src/app/helpers/MustMatch';
import { SignupRequest } from 'src/app/payloads/requests/signup-request';
import { MessageResponse } from 'src/app/payloads/responses/message-response';
import { AuthService } from 'src/app/services/auth-service';
import { first, map } from 'rxjs/operators';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor( 
    private formBuilder : FormBuilder,
    private router : Router,
    private authService : AuthService
  ) { }

  signupForm : FormGroup;
  submitted : boolean = false;
  error : string = '';
  message : string; 

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      firstname: ['', [Validators.required, Validators.maxLength(50)]],
      lastname: ['', [Validators.required, Validators.maxLength(50)]],
      email: ['', [Validators.required, Validators.maxLength(50),Validators.email]],
      username: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
      passwordConfirm : ['', [Validators.required,Validators.minLength(6), Validators.maxLength(20)]],
      studentId: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
      confirmStudentId : ['', [Validators.required, Validators.minLength(8), Validators.maxLength(8)]]
    }, {
    
      validators : [MustMatch('password', 'passwordConfirm'), 
      MustMatch('studentId', 'confirmStudentId')]

    });
  }

  get f() { 
    return this.signupForm.controls; 
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
