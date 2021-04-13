import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { OfferRideComponent } from './carpool/carpool.component';
import { LoginFormComponent} from './login-page/login-page';

const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'employees', component: EmployeeListComponent },
  { path: 'add', component: HomeScreenComponent },
  { path: 'offerride', component: OfferRideComponent },
  { path: 'home', component: HomeScreenComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
