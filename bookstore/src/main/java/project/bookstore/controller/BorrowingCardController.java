package project.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bookstore.dto.BorrowingCardDTO;
import project.bookstore.model.BorrowingcardModel;
import project.bookstore.repository.BorrowingCardRepository;
import project.bookstore.service.BorrowingCardService;

import java.util.List;


@RestController
@RequestMapping(value = "borrowingcards", produces = "application/json")
public class BorrowingCardController {

    @Autowired
    private BorrowingCardService borrowingCardService;


    @GetMapping
    public ResponseEntity<List<BorrowingCardDTO>> getAllBorrowingCard(){
        return ResponseEntity.ok().body(borrowingCardService.getAllBorrowingCard());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BorrowingCardDTO> getBorrowingCardFromId(@PathVariable Long id){
        BorrowingCardDTO borrowingCardDTO = borrowingCardService.findById(id);
        return ResponseEntity.ok().body(borrowingCardDTO);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<BorrowingCardDTO> addBorrowingBook(@RequestBody BorrowingcardModel borrowingcardModel) {
        BorrowingCardDTO borrowingCard = borrowingCardService.addBorrowingBook(borrowingcardModel);
        return ResponseEntity.ok().body(borrowingCard);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<BorrowingCardDTO> updateBorrowingBook(@PathVariable Long id, @RequestBody BorrowingcardModel borrowingcardModel){
        BorrowingCardDTO borrowingCardDTO = borrowingCardService.updateBorrowingBook(id, borrowingcardModel);
        return ResponseEntity.ok().body(borrowingCardDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBorrowingBook(@PathVariable Long id) {
        borrowingCardService.deleteBorrowingBook(id);
        return ResponseEntity.ok().body("SUCCESS DELETING BorrowingCard "+id);
    }
}
