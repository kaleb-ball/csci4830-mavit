import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CreateCommentRequest } from 'src/app/payloads/requests/comment-request';
import { AuthService } from 'src/app/services/auth-service';
import { CommentService } from 'src/app/services/comment.service';
import { Comment } from 'src/app/models/comment'
import { ThreadService } from 'src/app/services/thread.service';
import { Thread } from 'src/app/models/thread';

@Component({
  selector: 'app-thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.scss']
})
export class ThreadComponent implements OnInit {

  threadId : any
  commentForm : FormGroup
  comments : Comment[]
  error : any
  thread : Thread

  constructor(    
    private route : ActivatedRoute,
    private commentService : CommentService,
    private formBuilder : FormBuilder,
    private authService : AuthService,
    private threadSevice : ThreadService
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params=> {
      this.threadId = params.get("id")
    })

    this.commentForm = this.formBuilder.group({
      text : ['', Validators.required]
    })

    this.getComments();

    this.threadSevice.getThreadById(this.threadId).subscribe((next : Thread) => {
        this.thread = next;
    })
  }

  getComments() {
    this.commentService.getCommentsByThreadId(this.threadId).subscribe({
      next : (next : Comment[]) => {
        this.comments = next.sort((a,b) => (a.dateTime > b.dateTime) ? -1 : 1)
      }
    })
  }

  post() {
    let commentRequest = new CreateCommentRequest()

    commentRequest.text = this.commentForm.controls.text.value
    commentRequest.user = this.authService.currentUserValue.username
    commentRequest.threadId = this.threadId;

    // let comment = new Comment()
    // comment.dateTime = formatDate(new Date(), 'short', 'en-US');
    // comment.user = commentRequest.user
    // comment.text = commentRequest.text

    // this.comments.unshift(comment);

    this.commentService.createComment(commentRequest).subscribe({
      error : error => {
        this.error = error
      }
    })
    setInterval(()=> {
      this.getComments();
    },1000);
    this.commentForm.reset()

  }

}
