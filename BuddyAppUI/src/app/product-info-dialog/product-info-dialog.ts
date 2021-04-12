import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
export interface DialogData {};
import {DialogData} from "../home-screen/home-screen.component";

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'product-info-dialog.html',
})

export class ProductInfoDialog {
  constructor(
    public dialogRef: MatDialogRef<ProductInfoDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
