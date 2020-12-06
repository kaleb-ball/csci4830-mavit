import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, NgModel, Validators } from '@angular/forms';
import {NgbModal, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import { CreateThreadRequest } from 'src/app/payloads/requests/create-thread-request';
import { ThreadService } from 'src/app/services/thread.service';

@Component({
  selector: 'app-create-thread',
  templateUrl: './create-thread.component.html',
  styleUrls: ['./create-thread.component.scss']
})
export class CreateThreadComponent implements OnInit {
  @Input() request : CreateThreadRequest;
  @Output() passEntry: EventEmitter<CreateThreadRequest> = new EventEmitter();
  createThreadForm : FormGroup

  ngOnInit(): void {
    this.createThreadForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  closeResult = '';

  constructor(
    private formBuilder : FormBuilder,
    private modalService: NgbModal,
    public activeModal : NgbActiveModal,
    private threadService : ThreadService
  ) {}

  get f() { 
    return this.createThreadForm.controls; 
  }

  onSubmit() {
    this.request.title = this.f.title.value
    this.request.description = this.f.description.value
    this.threadService.createThread(this.request);
    this.activeModal.close()


  }

}
