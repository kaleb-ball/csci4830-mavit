import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointService } from '../helpers/endpoint.service';
import { PageResponse } from '../payloads/responses/PageResposne';

@Injectable({
  providedIn: 'root'
})
export class PageService {

  constructor(
    private http : HttpClient,
    private endpointService : EndpointService
  ) { }

  
  getPageById(id : number) {
    return this.http.get<PageResponse>(this.endpointService.PAGE_BASE + '/' + id);
  }

}
