import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoaidanhmucService {

  constructor(private http: HttpClient) { }

  getListLoaiDanhMuc(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/loaidanhmuc')
  }

  insertLoaiDanhMuc(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/loaidanhmuc', data);
  }
  findLoaiDanhMuc(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/loaidanhmuc/find', data);
  }
  updateDanhMuc(data: any, id: Number): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/loaidanhmuc/${id}`, data);
  }

  deleteDanhMuc(id: Number) {
    return this.http.delete(`http://localhost:8080/api/loaidanhmuc/${id}`);
  }

}
