import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './common/not-found/not-found.component';
import { UnauthorizedComponent } from './common/unauthorized/unauthorized.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { AuthGuard } from './helpers/auth-guard';

const routes: Routes = [
  {path : 'login', component : LoginComponent},
  {path : 'signup', component : SignupComponent},
  {path : 'home', component : HomeComponent, canActivate:[AuthGuard]},
  {path : 'unauthorized', component : UnauthorizedComponent},
  {path : '**', component : NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
