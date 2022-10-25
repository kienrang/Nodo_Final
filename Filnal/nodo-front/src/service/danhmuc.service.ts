import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DanhmucService {

  constructor(private http: HttpClient) { }
  getListDanhMuc(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/danhmuc')
  }
  findDanhMuc(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/danhmuc/find', data)
  }

  insertData(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/danhmuc', data);
  }
  updateData(data: any, id: number): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/danhmuc/${id}`, data);
  }

  deleteData(id: Number) {
    return this.http.delete(`http://localhost:8080/api/danhmuc/${id}`);
  }


}
