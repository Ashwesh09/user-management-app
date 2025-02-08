import { EnvironmentProviders, Injectable, Provider } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of } from 'rxjs';
 
@Injectable({
  providedIn: 'root', 
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api/users'; 
 
  constructor(public http: HttpClient) {}
 
  loadData(): Observable<any> {
    return this.http.get(`${this.baseUrl}/load`);
  }
 
  // GET request
  searchUsers(query: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/search?query=${query}`).pipe(
      catchError(() => of([]))
    );
  }
 
  getAllUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/get-all-users`);
  }
 
  getUserById(id : string): Observable<any> {
    return this.http.get(`${this.baseUrl}/get-by-id?id=${id}`);
  }
 
}