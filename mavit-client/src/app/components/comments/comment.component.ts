import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Comment } from 'src/app/models/comment';
import { CreateCommentRequest } from 'src/app/payloads/requests/comment-request';
import { AuthService } from 'src/app/services/auth-service';
import { CommentService } from 'src/app/services/comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent implements OnInit {

  commentList : Comment[];

  commentForm : FormGroup
  
  error
  
  constructor(
    private commentService : CommentService,
    private formBuilder : FormBuilder,
    private authService : AuthService
  ) { }

  ngOnInit(): void {

    this.commentForm = this.formBuilder.group({
      text : ['', Validators.required]
    })

    this.commentService.getAllComments().subscribe({
      next : (next : Comment[]) => {
        this.commentList = next;
        this.commentList.sort((a,b) => (a.dateTime > b.dateTime) ? -1 : 1)
        this.commentList;
      }
    })

  }

  post() {
    let commentRequest = new CreateCommentRequest()

    commentRequest.text = this.commentForm.controls.text.value
    commentRequest.user = this.authService.currentUserValue.username

    let comment = new Comment()
    comment.dateTime = formatDate(new Date(), 'short', 'en-US');
    comment.user = commentRequest.user
    comment.text = commentRequest.text

    this.commentList.unshift(comment);

    this.commentService.createComment(commentRequest).subscribe({
      error : error => {
        this.error = error
      }
    })
    this.commentForm.reset()

  }

}
