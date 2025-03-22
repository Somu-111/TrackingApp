import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { SignupServiceService } from '../../services/signup-service.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  regForm: FormGroup;

  constructor(private fb: FormBuilder, private signup: SignupServiceService, private router: Router) {
    this.regForm = this.fb.group(
      {
        email: ['', [Validators.required, Validators.email]],
        userName: ['', [Validators.required, Validators.minLength(3)]],
        occupation: ['', Validators.required],
        companyName: [''],
        contactNo: ['',Validators.pattern(/^[0-9]{10}$/)],
        password: [
          '',
          [
            Validators.required,
            Validators.minLength(8),
            Validators.pattern(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/)
          ]
        ],
        confirmPassword: ['', Validators.required]
      },
      { validators: this.passwordMatchValidator }
    );
  }

  passwordMatchValidator(control: AbstractControl) {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { mismatch: true };
  }

  checkLogin() {
    if (this.regForm.invalid) {
      alert('Please fill out all required fields correctly.');
      return;
    }

    this.signup.saveSignup(this.regForm.value).subscribe({
      next: () => {
        alert('Data successfully saved!');
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error('Signup error:', error);
        alert('An error occurred while signing up. Please try again.');
      }
    });
  }

  // ✅ Updated to return controls as an index signature
  get f() {
    return this.regForm.controls;
  }
}
