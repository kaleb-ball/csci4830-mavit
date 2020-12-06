import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormBuilder, ReactiveFormsModule, FormControl } from '@angular/forms';
import { HttpClient, HttpClientModule, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor } from './helpers/jwt.interceptor';
import { ErrorInterceptor } from './helpers/error.interceptor';
import { HomeComponent } from './components/home/home.component';
import { UnauthorizedComponent } from './common/unauthorized/unauthorized.component';
import { NotFoundComponent } from './common/not-found/not-found.component';
import { CommentComponent } from './components/comments/comment.component';
import { PageComponent } from './components/page/page.component';
import { CreateThreadComponent } from './components/create-thread/create-thread.component';
import { ThreadComponent } from './components/thread/thread.component'
import { RouterModule } from '@angular/router';
import { HashLocationStrategy } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    UnauthorizedComponent,
    NotFoundComponent,
    CommentComponent,
    PageComponent,
    CreateThreadComponent,
    ThreadComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModalModule
  ],
  providers: [
    FormBuilder,
    HttpClient,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
