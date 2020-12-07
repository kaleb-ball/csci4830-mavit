import { formatDate } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CreateCommentRequest } from 'src/app/payloads/requests/comment-request';
import { PageResponse } from 'src/app/payloads/responses/PageResposne';
import { AuthService } from 'src/app/services/auth-service';
import { CommentService } from 'src/app/services/comment.service';
import { PageService } from 'src/app/services/page.service';
import { Comment } from 'src/app/models/comment'
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CreateThreadComponent } from '../create-thread/create-thread.component';
import { CreateThreadRequest } from 'src/app/payloads/requests/create-thread-request';
import { Thread } from 'src/app/models/thread';
import { ThreadService } from 'src/app/services/thread.service';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.scss']
})
export class PageComponent implements OnInit {


  id : any;
  pageTitle : String;
  commentList : Comment[];
  commentForm : FormGroup
  threads  : Thread[];

  constructor(
    private route : ActivatedRoute,
    private pageService : PageService,
    private commentService : CommentService,
    private formBuilder : FormBuilder,
    private authService : AuthService,
    public modalService: NgbModal,
    private threadService : ThreadService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params=> {
      this.id = params.get("id")
    })

    this.pageService.getPageById(this.id).subscribe((response : PageResponse)=> {
      this.pageTitle = response.title;
    })

    this.getThreads();
    // this.threadService.getThreadByPageId(this.id).subscribe((response : Thread[])=>{
    //   this.threads = response.sort((a,b) => (a.editedDateTime > b.editedDateTime) ? -1 : 1);
    // })

  }

  getThreads() {
    this.threadService.getThreadByPageId(this.id).subscribe((response : Thread[])=>{
      this.threads = response.sort((a,b) => (a.editedDateTime > b.editedDateTime) ? -1 : 1);
    })
  }


  openModal() {
    let request = new CreateThreadRequest()
    request.pageId = this.id; 
    request.createUsername = this.authService.currentUserValue.username
    const modalRef = this.modalService.open(CreateThreadComponent)
    modalRef.componentInstance.request = request;
    modalRef.result.then(() => {
      // this.router.navigate(['/page/' + this.id])
      setInterval(()=> {
        this.getThreads();
      },1000);
    })
    // modalRef.result.finally({

    // })
  }

}
