import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/heyBuddy';
  records = [
    {
      "id" : 1,
      "name" : "Rahul",
    },
    {
      "id" : 2,
      "name" : "Pranav",
    },
    {
      "id" : 3,
      "name" : "Vannya",
    },
    {
      "id" : 4,
      "name" : "Mrunali",
    }
  ];

  constructor(private http: HttpClient) { }

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
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getListData() : Observable<any> {
    return this.http.post(`${this.baseUrl}/getproducts/all`, {"searchText": "",
      "sortOrder": "",
      "listingType": 0});
  }
}
