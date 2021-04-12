import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import {ConfirmationDialog} from '../confirm-dialog/confirm-dialog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
export interface DialogData {};
import {ProductInfoDialog} from '../product-info-dialog/product-info-dialog';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {OfferRide} from '../carpool/offer-ride';
import {FindRide} from '../carpool/find-ride';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.css']
})
export class HomeScreenComponent implements OnInit {

  employee: Employee = new Employee();
  offerRide: OfferRide = new OfferRide();
  findRide: FindRide = new FindRide();
  submitted = false;
  records = [];
  isLinear = false;
  showOfferRide = false;
  showNeedRide = false;
  zeroFormGroup: FormGroup;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  fifthFormGroup: FormGroup;

  zeroFormGroupFindRide: FormGroup;
  firstFormGroupFindRide: FormGroup;
  secondFormGroupFindRide: FormGroup;
  thirdFormGroupFindRide: FormGroup;
  fourthFormGroupFindRide: FormGroup;
  fifthFormGroupFindRide: FormGroup;

  constructor(private employeeService: EmployeeService,
              private router: Router, public dialog: MatDialog, private _formBuilder: FormBuilder) {
    this.getList();
  }

  ngOnInit() {
    this.zeroFormGroup = this._formBuilder.group({
      zeroCtrl: ['', Validators.required]
    });
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', Validators.required]
    });
    this.fourthFormGroup = this._formBuilder.group({
      fourthCtrl: ['', Validators.required]
    });
    this.fifthFormGroup = this._formBuilder.group({
      fifthCtrl: ['', Validators.required]
    });

    this.zeroFormGroupFindRide = this._formBuilder.group({
      zeroCtrlFindRide: ['']
    });
    this.firstFormGroupFindRide = this._formBuilder.group({
      firstCtrlFindRide: ['', Validators.required]
    });
    this.secondFormGroupFindRide = this._formBuilder.group({
      secondCtrlFindRide: ['', Validators.required]
    });
    this.thirdFormGroupFindRide = this._formBuilder.group({
      thirdCtrlFindRide: ['', Validators.required]
    });
    this.fourthFormGroupFindRide = this._formBuilder.group({
      fourthCtrlFindRide: ['', Validators.required]
    });
    this.fifthFormGroupFindRide = this._formBuilder.group({
      fifthCtrlFindRide: ['', Validators.required]
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Employee();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  submitRide() {
    this.employeeService.submitRide(this.offerRide).subscribe(data => {
        console.log(data);
      },
      error => console.log(error));
  }

  searchRide() {
    this.employeeService.searchRide(this.findRide).subscribe(data => {
        console.log(data);
      },
      error => console.log(error));
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

  getList() {
    this.employeeService.getListData()
      .subscribe(data => {
        console.log(data);
        this.records = data.products;
      }, error => console.log(error));
  }

   openDialog() {
    const dialogRef = this.dialog.open(ConfirmationDialog,{
      data:{
        message: 'Are you sure want to delete?',
        buttonText: {
          ok: 'Save',
          cancel: 'No'
        }
      }
    });
    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        const a = document.createElement('a');
        a.click();
        a.remove();
      }
    });
  }

  openProductDetails(selectedProductData): void {
    const dialogRef = this.dialog.open(ProductInfoDialog, {
      width: '250px',
      data: {product: selectedProductData}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  gotoOfferRide() {
    this.router.navigate(['/offerride']);
  }
}
