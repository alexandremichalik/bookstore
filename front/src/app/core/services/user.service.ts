import { Injectable } from '@angular/core';
import { User } from '../classes/User';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: User[] = [];

  constructor(
    private http: HttpClient
  ) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(environment.apiUrl+"/users");
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(environment.apiUrl+"/users/"+id);
  }
}
