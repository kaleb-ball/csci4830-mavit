import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { EndpointService } from '../helpers/endpoint.service';
import { User } from '../models/user';
import { LoginRequet } from '../payloads/requests/login-requet';
import { SignupRequest } from '../payloads/requests/signup-request';
import { MessageResponse } from '../payloads/responses/message-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

private currentUserSubject : BehaviorSubject<User>
private currentUser : Observable<User>
private loggedIn : boolean


  constructor(
    private http : HttpClient,
    private endpointService : EndpointService
  ) { 
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue() : User {
    return this.currentUserSubject.value;
  }

  public get isLoggedIn() : boolean {
      return this.loggedIn
  }

  login(loginRequest : LoginRequet) {
    return this.http.post<User>(this.endpointService.LOGIN_API, loginRequest).pipe(map(user => {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.currentUserSubject.next(user);
      this.loggedIn = true;
      return user;
    }));
  }


  signup(signupRequest : SignupRequest) {
    return this.http.post(this.endpointService.SIGNUP_API, signupRequest)
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
    this.loggedIn = false;
    
}

}
