import { Component, OnDestroy, OnInit } from '@angular/core';
import { Book } from 'src/app/core/classes/Book';
import { BookService } from 'src/app/core/services/book.service';

@Component({
  selector: 'app-book-description',
  templateUrl: './book-description.component.html',
  styleUrls: ['./book-description.component.scss']
})
export class BookDescriptionComponent implements OnInit, OnDestroy{

  searchForm: string = '';
  book: Book | undefined;

  constructor(
    private bookService: BookService
  ) {}

  ngOnInit(): void {

  }

  ngOnDestroy(): void {

  }

  submit(): void {
    this.bookService.getBookByEan13(this.searchForm).subscribe({
      next: res => this.book = res,
      error: err => console.error("No book found")
    })
  }

}
