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
  GET_COMMENTS_BY_THREAD_ID = this.COMMENT_BASE + '/commentsByThreadId'
  CREATE_COMMENT = this.COMMENT_BASE + '/create'


  COMMON_BASE = this.API_BASE + '/common'
  GET_ALL_COLLEGES = this.COMMON_BASE + '/allColleges'
  GET_MAJORs_FOR_COLLEGE = this.COMMON_BASE + '/majorsByCollege'

  HOME_BASE = this.API_BASE + '/home'
  GET_HOME_CONFIG = this.HOME_BASE + '/config'

  PAGE_BASE = this.API_BASE + '/page'

  THREAD_BASE = this.API_BASE + '/thread'
  CREATE_THREAD = this.THREAD_BASE + '/create'
  GET_THREADS_BY_PAGE_ID = this.THREAD_BASE + '/threadsByPageId'
  GET_THREAD_BY_ID = this.THREAD_BASE + '/threadById'
  
}
