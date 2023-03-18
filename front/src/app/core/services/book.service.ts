import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Book } from '../classes/Book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  books: Book[] = [];

  constructor(
    private http: HttpClient
  ) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(environment.apiUrl+"/books");
  }

  getBookByEan13(ean13: string): Observable<Book> {
    return this.http.get<Book>(environment.apiUrl+"/books/"+ean13);
  }
}
