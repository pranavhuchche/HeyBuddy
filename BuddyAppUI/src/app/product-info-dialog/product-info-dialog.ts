import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
export interface DialogData {};
import {DialogData} from "../home-screen/home-screen.component";
import {EmployeeService} from "../employee.service";

@Component({
  selector: 'product-info-dialog',
  templateUrl: 'product-info-dialog.html',
  styleUrls: ['product-info-dialog.css']
})

export class ProductInfoDialog {
  productMarkedInterested = false;
  constructor(
    public dialogRef: MatDialogRef<ProductInfoDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData, private employeeService: EmployeeService) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  markInterested(id) : void {
    this.employeeService.markProductAsInterested(id).subscribe(data => {
    }, error => console.log(error));
  }
}
