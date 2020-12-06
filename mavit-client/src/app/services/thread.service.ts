import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointService } from '../helpers/endpoint.service';
import { Thread } from '../models/thread';
import { CreateThreadRequest } from '../payloads/requests/create-thread-request';

@Injectable({
  providedIn: 'root'
})
export class ThreadService {

  constructor(    
    private http : HttpClient,
    private endpointService : EndpointService
  ) { }

    createThread(createThreadRequest : CreateThreadRequest) {
        this.http.post(this.endpointService.CREATE_THREAD, createThreadRequest).subscribe()
    }

    getThreadByPageId(id : number) {
      return this.http.get<Thread[]>(this.endpointService.GET_THREADS_BY_PAGE_ID + '/' + id)
    }

    getThreadById(id : number) {
      return this.http.get(this.endpointService.GET_THREAD_BY_ID + '/' + id)
    }


}
