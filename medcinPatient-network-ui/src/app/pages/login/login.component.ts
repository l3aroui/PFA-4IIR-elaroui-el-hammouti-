import { Component } from '@angular/core';
import {AuthenticationRequest} from "../../services/models/authentication-request";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  authRequest: AuthenticationRequest={email:'',password:''}
  errorMsg: Array<String> =[]

  constructor(
    private router:Router,
    private authService:AuthenticationService,
    //anotherServer
  ) {
  }

  login():void {
    this.errorMsg=[];
    this.authService.authenticationResponse({
      body: this.authRequest
    }).subscribe({
      next: (res)=>{
        //todo save the token
        this.router.navigate(['home'])
      },
      error:(err)=>{
        console.log(err)
        if (err.error.validateErrors){
          this.errorMsg=err.error.error.validateErrors
        }else {
          this.errorMsg.push(err.error.errorMsg);
        }
      }

    })
  }

  register():void {
    this.router.navigate(['register'])
  }
}
