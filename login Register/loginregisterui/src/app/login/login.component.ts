import { Component } from '@angular/core';
import {AuthenticationRequest} from "../model/authentication-request";
import {Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication.service";
import Swal from 'sweetalert2';
import {TokenService} from "../service/token.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  authRequest:AuthenticationRequest ={email:'',password:''};

  errorMsg:Array<string> = [];

  constructor(private router:Router,
              private authService:AuthenticationService,
              private tokenService:TokenService) {
  }


  login() {
    this.errorMsg = [];
    this.authService.authenticate({
      body: this.authRequest
    }).subscribe({
      next: (res) => {


        this.tokenService.token = res.token as string;

        Swal.fire({
          title: 'Success!',
          text: 'Login Successfully',
          icon: 'success',
          confirmButtonText: 'OK'
        });

      },
      error: (err) => {
        console.log(err);

        if(err.error.validationErrors){

          this.errorMsg = err.error.validationErrors
        }else {

          this.errorMsg.push(err.error.error);
        }
      }
    });
  }
  async register() {

    await this.router.navigate(['register'])

  }
}
