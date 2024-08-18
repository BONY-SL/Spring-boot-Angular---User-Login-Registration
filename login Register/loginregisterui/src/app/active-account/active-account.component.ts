import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-active-account',
  templateUrl: './active-account.component.html',
  styleUrl: './active-account.component.css'
})
export class ActiveAccountComponent {

  message ='';
  isOkay = true;
  submitted =false;

  constructor(private router:Router,
              private authService:AuthenticationService) {
  }

  onCodeCompleted(token: string) {
    this.confirmAccount(token);
  }

  async redirectToLogin() {

    await this.router.navigate(['login']);

  }

  private confirmAccount(token: string) {

    this.authService.confirm({
      token
    }).subscribe({
      next: () => {
        this.message = 'Your account has been successfully activated.\nNow you can proceed to login';
        this.submitted = true;
        this.isOkay = true;
      },
      error: () => {
        this.message = 'Token has been expired or invalid';
        this.submitted = true;
        this.isOkay = false;
      }
    });
  }
}
