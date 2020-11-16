import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EndpointService {

  constructor() { }
  
  API_BASE = `${environment.apiUrl}`
  
  
  AUTH_BASE = this.API_BASE + '/auth'
  LOGIN_API = this.AUTH_BASE + '/login'
  SIGNUP_API = this.AUTH_BASE + '/signup'

  COMMENT_BASE = this.API_BASE + '/comment'
  GET_ALL_COMMENTS = this.COMMENT_BASE + '/getAllComments'
  CREATE_COMMENT = this.COMMENT_BASE + '/create'

}
