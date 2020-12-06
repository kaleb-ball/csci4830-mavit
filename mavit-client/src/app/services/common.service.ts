import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointService } from '../helpers/endpoint.service';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(    
    private http : HttpClient,
    private endpointService : EndpointService
  ) { }


  getAllColleges()  {
    return this.http.get(this.endpointService.GET_ALL_COLLEGES);
  } 

  getMajorsForCollege(code : String) {
    return this.http.get(this.endpointService.GET_MAJORs_FOR_COLLEGE + '/' + code)
  }
}
