import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointService } from '../helpers/endpoint.service';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(
    private http : HttpClient,
    private endpointService : EndpointService
  ) { }

  getHomeConfig (username : String) {
    return this.http.get(this.endpointService.GET_HOME_CONFIG + '/' + username);
  }

}
