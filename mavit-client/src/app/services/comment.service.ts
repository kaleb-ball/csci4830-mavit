import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointService } from '../helpers/endpoint.service';
import { CreateCommentRequest } from '../payloads/requests/comment-request';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(
    private http : HttpClient,
    private endpointService : EndpointService

  ) { }

  getCommentsByThreadId (id : number) {
    return this.http.get(this.endpointService.GET_COMMENTS_BY_THREAD_ID + '/' + id);
  }

  createComment (createComment : CreateCommentRequest) {
    return this.http.post(this.endpointService.CREATE_COMMENT, createComment)
  }

}
