import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Définir une interface pour représenter un utilisateur
export interface FullUser {
  id: string;
  name: string;
  email: string;
  // Ajoute d'autres propriétés si nécessaire
}

@Injectable({
  providedIn: 'root', // Rendu disponible dans toute l'application
})
export class UserService {
  private baseUrl = 'http://localhost:8080/api/user'; // URL de ton API backend

  constructor(private http: HttpClient) {}

  // Méthode pour récupérer un utilisateur par son ID
  getUserById(id: string): Observable<FullUser> {
    return this.http.get<FullUser>(`${this.baseUrl}/${id}`);
  }

  // Méthode pour créer un utilisateur
  createUser(user: FullUser): Observable<string> {
    return this.http.post<string>(this.baseUrl, user);
  }

  // Méthode pour mettre à jour un utilisateur
  updateUser(user: FullUser): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/${user.id}`, user);
  }

  // Méthode pour supprimer un utilisateur
  deleteUser(id: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
