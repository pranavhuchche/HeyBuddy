import {Component, OnInit, Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {FormGroup, FormControl} from '@angular/forms';
import {DialogData} from "../home-screen/home-screen.component";
import {EmployeeService} from "../employee.service";

@Component({
  selector: 'create-product-dialog',
  templateUrl: 'create-product-dialog.html',
  styleUrls: ["create-product-dialog.css"]
})

export class CreateProductDialog {
  showDialog = true;
  listingTypes = ["SELL","BUY"];

  createForm: FormGroup = new FormGroup({
    productName: new FormControl(''),
    description: new FormControl(''),
    mobileNumber: new FormControl(''),
    cost_from: new FormControl(''),
    cost_to: new FormControl(''),
    username: new FormControl(localStorage.getItem("username")),
    listingType: new FormControl(''),
    status: new FormControl(true),
  });

  constructor(
    public dialogRef: MatDialogRef<CreateProductDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData, private employeeService: EmployeeService) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onCancel() {
    this.onNoClick();
    this.showDialog = !this.showDialog;
  }

  submit() {
    if (this.createForm.valid && this.showDialog) {
      this.employeeService.createProduct(this.createForm.value).subscribe(data => {
        this.onCancel();
        this.onNoClick();
        alert(data.productName + " Product Created Successfully");
      }, error => alert(error.message));
    }
  }
}
