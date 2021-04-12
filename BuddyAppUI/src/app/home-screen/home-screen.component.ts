import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import {ConfirmationDialog} from '../confirm-dialog/confirm-dialog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
export interface DialogData {};
import {ProductInfoDialog} from '../product-info-dialog/product-info-dialog';

@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrls: ['./home-screen.component.css']
})
export class HomeScreenComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;
  records = [];
  isShowProductDetails = false;

  constructor(private employeeService: EmployeeService,
    private router: Router, public dialog: MatDialog) {
    this.getList();
  }

  ngOnInit() {
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

/*  openProductDetails(selectedProductData) {
    this.isShowProductDetails = !this.isShowProductDetails;
    this.dialog.open(DialogDataExampleDialog, {
      data: {
        product: selectedProductData
      }
    });
  }*/

  openProductDetails(selectedProductData): void {
    const dialogRef = this.dialog.open(ProductInfoDialog, {
      width: '250px',
      data: {product: selectedProductData}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
