import {Input, Component, Output, EventEmitter} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {EmployeeService} from '../employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.html',
  styleUrls: ['./login-page.css']
})
export class LoginFormComponent {
  showSignUpSection = false;

  constructor(private employeeService: EmployeeService, private router: Router) {
  }

  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  signUpForm: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    name: new FormControl(''),
    dob: new FormControl(''),
    mobile: new FormControl(''),
    email: new FormControl(''),
  });

  gotoList() {
    this.router.navigate(['/home']);
  }

  submit() {
    if (this.form.valid) {
      this.employeeService.validateUser(this.form.value).subscribe(data => {
        console.log(data);
        this.gotoList();
      }, error => alert(error.message));
    }
  }

  onSignUp() {
    this.showSignUpSection = !this.showSignUpSection;
    this.signUpForm.reset();
    this.form.reset();
  }

  onCreate() {
    if (this.signUpForm.valid) {
      this.employeeService.createUser(this.signUpForm.value).subscribe(data => {
        alert("Created Successfully");
        console.log(data);
      }, error => alert(error.message));
    }
    this.showSignUpSection = !this.showSignUpSection;
    this.form.reset();
  }

  @Input() error: string | null;

  @Output() submitEM = new EventEmitter();
}
