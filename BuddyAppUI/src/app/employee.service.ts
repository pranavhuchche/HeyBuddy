import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {OfferRide} from './carpool/offer-ride';
import {FindRide} from './carpool/find-ride';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/heyBuddy';
  const
  httpOptions = {
    headers: new HttpHeaders({
      // TODO : remove hardcoded username.
      user: 'test_user1'
    })
  };

  constructor(private http: HttpClient) {
  }

  getEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getListData(): Observable<any> {
    return this.http.post(`${this.baseUrl}/getproducts/all`, {
      "searchText": "",
      "sortOrder": "",
      "listingType": 0
    }, this.httpOptions);
  }

  submitRide(offerRide: OfferRide): Observable<any> {
    offerRide.time = new Date(offerRide.dateTime).getTime();
    offerRide.vehicleType = offerRide.vehicleType === 'Car' || offerRide.vehicleType === 'car' ? 'CAR' : 'BIKE';

    return this.http.post(`${this.baseUrl}/createride`, offerRide, this.httpOptions);
  }

  searchRide(findRide: FindRide): Observable<any> {
    if (findRide.vehicleType === 'Car') {
      findRide.vehicleType = 'CAR';
    }
    if (findRide.vehicleType === 'Bike') {
      findRide.vehicleType = 'BIKE';
    }
    return this.http.post(`${this.baseUrl}/searchride`, findRide, this.httpOptions);
  }

  validateUser(value: object): Observable<any> {
    return this.http.post(`${this.baseUrl}/validateuser`, value);
  }

  createUser(value: object): Observable<any> {
    return this.http.post(`${this.baseUrl}/createuser`, value);
  }
}
