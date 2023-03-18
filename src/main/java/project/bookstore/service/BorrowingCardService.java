package project.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.bookstore.dto.BookDTO;
import project.bookstore.dto.BorrowingCardDTO;
import project.bookstore.dto.UserDTO;
import project.bookstore.model.BorrowingcardModel;
import project.bookstore.repository.BorrowingCardRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingCardService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowingCardRepository borrowingCardRepository;

    public List<BorrowingCardDTO> getAllBorrowingCard(){
        try {
            return borrowingCardRepository.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }

    public BorrowingCardDTO findById(Long id){
        Optional<BorrowingCardDTO> borrowingCardDTO = borrowingCardRepository.findById(id);
        if(borrowingCardDTO.isPresent()){
            return borrowingCardDTO.get();
        }else{
            throw new EntityNotFoundException("Borrowing Card not found");
        }
    }

    public List<BorrowingCardDTO> findByBook(BookDTO bookDTO){
        try{
            return borrowingCardRepository.findBorrowingCardDTOSByBook(bookDTO);
        }catch (DataAccessException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }

    public List<BorrowingCardDTO> findByUserId(UserDTO userDTO){
        try{
            return borrowingCardRepository.findBorrowingCardDTOSByUser(userDTO);
        }catch (DataAccessException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }


    private BorrowingCardDTO saveAndFlush(BorrowingCardDTO borrowingCardDTO){
        try{
            return borrowingCardRepository.saveAndFlush(borrowingCardDTO);
        }catch (DataAccessException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }


    public BorrowingCardDTO addBorrowingBook(BorrowingcardModel borrowingcardModel){
        BorrowingCardDTO borrowingCard = new BorrowingCardDTO();
        borrowingCard.setUser(userService.getUserById(borrowingcardModel.getUserId()));
        borrowingCard.setBook(bookService.getBookById(borrowingcardModel.getBookEAN13()));
        borrowingCard.setLoanDate(new Date());
        this.saveAndFlush(borrowingCard);
        return borrowingCard;
    }

    public BorrowingCardDTO updateBorrowingBook(Long id, BorrowingcardModel borrowingcardModel){
        if(borrowingcardModel.getRealReturnDate() == null){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
        BorrowingCardDTO borrowingCardDTO = this.findById(id);
        borrowingCardDTO.setRealReturnDate(borrowingcardModel.getRealReturnDate());
        return this.saveAndFlush(borrowingCardDTO);
    }

    public void deleteBorrowingBook(Long id){
        BorrowingCardDTO borrowingCardDTO = this.findById(id);
        try{
            borrowingCardRepository.delete(borrowingCardDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
        }
    }
}
