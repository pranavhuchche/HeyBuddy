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
  selectedProductData = {};
  bIsProductInterested = false;
  constructor(
    public dialogRef: MatDialogRef<ProductInfoDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData, private employeeService: EmployeeService) {
    this.selectedProductData = data["product"];
    this.bIsProductInterested = data["product"].isInterested;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  markInterested() : void {
    this.employeeService.markProductAsInterested(this.selectedProductData["productId"]).subscribe(data => {
      this.onNoClick();
    }, error => console.log(error));
  }
}
