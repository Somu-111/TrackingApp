import { Component } from '@angular/core';
import { Route, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { LoginServiceService } from '../../services/loginService/login-service.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink,RouterLinkActive,CommonModule,FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private loginService:LoginServiceService,private router:Router){};

  loginData:any={

    tenantId:'',
    userId:'',
    password:'',
    occupation:'',
    status:0
  }

  checkLogin(){
    this.loginService.checkLogin(this.loginData).subscribe(
      (resonse)=>{

        if(resonse.status==1){
          alert("Login Sucessfull!!");
          this.router.navigate(["/dashboard"]);
        }
        else{
          alert(resonse.status);
        }

      },
      (error)=>{
        alert(error);
      }
    );
  }
}
