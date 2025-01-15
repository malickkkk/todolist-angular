import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface FullUser {
  id: string;
  name: string;
  email: string;
  // Autres propriétés si nécessaire
}

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/api/users'; // URL du backend Java

  constructor(private http: HttpClient) {}

  getUserById(id: string): Observable<FullUser> {
    return this.http.get<FullUser>(`${this.baseUrl}/${id}`);
  }

  createUser(user: FullUser): Observable<string> {
    return this.http.post<string>(this.baseUrl, user);
  }

  updateUser(user: FullUser): Observable<void> {
    return this.http.put<void>(this.baseUrl, user);
  }

  deleteUser(id: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
