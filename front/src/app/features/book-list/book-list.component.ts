import { Component, OnDestroy, OnInit } from '@angular/core';
import { Book } from 'src/app/core/classes/Book';
import { BookService } from 'src/app/core/services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit, OnDestroy {

  books: Book[] = []

  constructor(
    private bookService: BookService
    ) {}

  ngOnInit(): void {
    this.fetchBooks();
  }

  fetchBooks(): void {
    this.bookService.getBooks().subscribe({
      next: res => this.books = res,
      error: err => console.error("Error while fetching books : " + err)
    })
  }

  ngOnDestroy(): void {

  }
}
