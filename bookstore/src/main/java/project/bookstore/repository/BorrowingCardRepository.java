package project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.bookstore.dto.BookDTO;
import project.bookstore.dto.BorrowingCardDTO;
import project.bookstore.dto.UserDTO;

import java.util.List;

@Repository
public interface BorrowingCardRepository extends JpaRepository<BorrowingCardDTO,Long> {

    List<BorrowingCardDTO> findBorrowingCardDTOSByBook(BookDTO bookDTO);

    List<BorrowingCardDTO> findBorrowingCardDTOSByUser(UserDTO userDTO);

    List<BorrowingCardDTO> findByRealReturnDateIsNull();
}
