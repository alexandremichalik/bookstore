package project.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bookstore.dto.BookDTO;
import project.bookstore.service.BookService;
import project.bookstore.service.BorrowingCardService;

import java.util.List;

@RestController
@RequestMapping(value = "/books", produces = "application/json" )
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowingCardService borrowingCardService;

    @GetMapping
    public ResponseEntity getAllBooks(){
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }


    @GetMapping("/{id}")
    public ResponseEntity getBookFromIdEan13(@PathVariable String id){
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }

    @GetMapping("/search")
    public ResponseEntity searchBook(@RequestParam String title,  @RequestParam(required = false) String author, @RequestParam(required = false) String illustrator){
        return ResponseEntity.ok().body(bookService.findByTitleAuthorAndIllustrator(title, author, illustrator));
    }


    @GetMapping(value = "/{id}/borrowingcards")
    public ResponseEntity listBookBorrowinCard(@PathVariable String id){
        BookDTO bookDTO = bookService.getBookById(id);
        return ResponseEntity.ok().body(borrowingCardService.findByBook(bookDTO));
    }


}
