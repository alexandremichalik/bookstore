package project.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.bookstore.dto.BookDTO;
import project.bookstore.dto.BorrowingCardDTO;
import project.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks(){
        try {
            return bookRepository.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }

    public BookDTO getBookById(String ean13){
        Optional<BookDTO> bookDTO = bookRepository.findById(ean13);
        if(bookDTO.isPresent()){
            return bookDTO.get();
        }else{
            throw new EntityNotFoundException("Book not found");
        }
    }


    public List<BookDTO> findByTitleAuthorAndIllustrator(String title, String author, String illustrator) {
        try{
            return bookRepository.findByTitleContainingIgnoreCaseOrAuthorOrIllustrator(title, author, illustrator);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }

}
