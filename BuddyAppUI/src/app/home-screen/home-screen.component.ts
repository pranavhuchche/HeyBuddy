import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import {ConfirmationDialog} from '../confirm-dialog/confirm-dialog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
export interface DialogData {};
import {ProductInfoDialog} from '../product-info-dialog/product-info-dialog';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {OfferRide} from '../carpool/offer-ride';
import {FindRide} from '../carpool/find-ride';
import {MatSnackBar, MatTabChangeEvent} from '@angular/material';
import {OrganizeEvent} from '../carpool/event-organize';
import {CreateProductDialog} from '../create-product/create-product-dialog'

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.css']
})
export class HomeScreenComponent implements OnInit {

  employee: Employee = new Employee();
  offerRide: OfferRide = new OfferRide();
  findRide: FindRide = new FindRide();
  organizeEvent: OrganizeEvent = new OrganizeEvent();
  searchedRides = [];
  allSearchedRides = [];
  allSearchedEvents = [];
  submitted = false;
  records = [];
  showAllRide = false;
  showOfferRide = false;
  showNeedRide = false;
  showOrganizeEvents = false;
  showAllEvents = false;

  zeroFormControl = new FormControl();
  zeroFormGroup: FormGroup;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  fifthFormGroup: FormGroup;

  zeroFormControlFindRide = new FormControl();
  zeroFormControlList: string[] = ['Car', 'Bike'];
  zeroFormGroupFindRide: FormGroup;
  firstFormGroupFindRide: FormGroup;
  secondFormGroupFindRide: FormGroup;
  thirdFormGroupFindRide: FormGroup;
  fourthFormGroupFindRide: FormGroup;
  fifthFormGroupFindRide: FormGroup;
  selectedProductId: "";

  firstFormGroupEvent: FormGroup;
  secondFormGroupEvent: FormGroup;
  thirdFormGroupEvent: FormGroup;
  fourthFormGroupEvent: FormGroup;
  fifthFormGroupEvent: FormGroup;
  sixthFormGroupEvent: FormGroup;
  seventhFormGroupEvent: FormGroup;
  eighthFormGroupEvent: FormGroup;

  selectedTabIndex: 3;
  userDetails: {};
  fourthFormEventFormControl = new FormControl();
  fifthFormEventFormControl = new FormControl();
  sixthFormEventFormControl = new FormControl();
  eighthFormEventFormControl = new FormControl();

  fourthFormEventControlList: string[] = ['ONLINE', 'PHYSICAL'];
  fifthFormEventControlList: string[] = ['INDIVIDUAL', 'TEAM'];
  sixthFormEventControlList: boolean[] = [true, false];
  eighthFormEventControlList: boolean[] = [true, false];


  constructor(private employeeService: EmployeeService,
              private router: Router, public dialog: MatDialog, private _formBuilder: FormBuilder, private _snackBar: MatSnackBar) {
    this.getList();
  }

  ngOnInit() {
    this.zeroFormGroup = this._formBuilder.group({
      zeroFormControl: ['']
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

    this.firstFormGroupEvent = this._formBuilder.group({
      firstCtrlEvent: ['', Validators.required]
    });
    this.secondFormGroupEvent = this._formBuilder.group({
      secondCtrlEvent: ['', Validators.required]
    });
    this.thirdFormGroupEvent = this._formBuilder.group({
      thirdCtrlEvent: ['', Validators.required]
    });
    this.fourthFormGroupEvent = this._formBuilder.group({
      fourthCtrlEvent: ['']
    });
    this.fifthFormGroupEvent = this._formBuilder.group({
      fifthCtrlEvent: ['']
    });
    this.sixthFormGroupEvent = this._formBuilder.group({
      sixthCtrlEvent: ['']
    });
    this.seventhFormGroupEvent = this._formBuilder.group({
      seventhCtrlEvent: ['', Validators.required]
    });
    this.eighthFormGroupEvent = this._formBuilder.group({
      eighthCtrlEvent: ['']
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

  openSnackBar(msg) {
    this._snackBar.open(msg, '', {
      duration: 500
    });
  }

  searchRide() {
    this.employeeService.searchRide(this.findRide).subscribe(data => {
        console.log(data);
        this.searchedRides = data;
        this.searchedRides.forEach(ride => {
          let date = new Date(ride.time);
          ride.time = date.toString();
        });
      },
      error => console.log(error));
  }

  getAllRides() {
    this.employeeService.getAllRides().subscribe(data => {
        console.log(data);
        this.allSearchedRides = data;
        this.allSearchedRides.forEach(ride => {
          let date = new Date(ride.time);
          ride.time = date.toString();
        });
      },
      error => console.log(error));
  }

  getAllEvents() {
    this.employeeService.getAllEvents().subscribe(data => {
        console.log(data);
        this.allSearchedEvents = data;
        this.allSearchedEvents.forEach(event => {
          let date = new Date(event.time);
          event.time = date.toString();
        });
      },
      error => console.log(error));
  }

  submitEvent() {
    this.employeeService.organizeEvent(this.organizeEvent).subscribe(data => {
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

   openDialog(data) {
    this.selectedProductId = data.productId;
    const dialogRef = this.dialog.open(ConfirmationDialog,{
      data:{
        message: 'Are you Interested?',
        buttonText: {
          ok: 'yes',
          cancel: 'No'
        }
      }
    });
    dialogRef.afterClosed().subscribe((confirmed: boolean) => {
      if (confirmed) {
        this.employeeService.markProductAsInterested(this.selectedProductId)
          .subscribe(data => {
            console.log(data);
            this.getList();
          }, error => console.log(error));
        const a = document.createElement('a');
        a.click();
        a.remove();
      }
    });
  }

  openProductDetails(selectedProductData): void {
    const dialogRef = this.dialog.open(ProductInfoDialog, {
      width: '60%',
      height: '70%',
      data: {product: selectedProductData}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.getList();
      console.log('The dialog was closed');
    });
  }

  createProduct() {
    const dialogRef = this.dialog.open(CreateProductDialog, {});
    dialogRef.afterClosed().subscribe(result => {
      this.getList();
    });
  }

  gotoOfferRide() {
    this.router.navigate(['/offerride']);
  }

  onTabChanged($event: MatTabChangeEvent) {
    if (this.selectedTabIndex === 3) {
      this.employeeService.getUserDetails().subscribe(data => {
          console.log(data);
          this.userDetails = data;
        },
        error => console.log(error));
    }
  }
}
