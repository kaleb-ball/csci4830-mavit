import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginRequet } from 'src/app/payloads/requests/login-requet';
import { AuthService } from 'src/app/services/auth-service';
import { first } from 'rxjs/operators';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm : FormGroup;
  submitted : boolean = false;
  error : string = '';

  constructor(
    private formBuilder : FormBuilder,
    private router : Router,
    private authService : AuthService,
    private route : ActivatedRoute    ) { 
      if (this.authService.isLoggedIn) { 
        this.router.navigate(['/']);
    }
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  get f() { 
    return this.loginForm.controls; 
  }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    let loginRequet = new LoginRequet();
    loginRequet.username = this.f.username.value;
    loginRequet.password = this.f.password.value;
    this.authService.login(loginRequet)
        .pipe(first())
        .subscribe({
            next: () => {
                this.router.navigate(['/home']);
            },
            error: error => {
              this.error = error;
            }
        });
    }

}
