package project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bookstore.dto.BorrowingCardDTO;
import project.bookstore.dto.UserDTO;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDTO,Long> {

    List<UserDTO> findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(String lastname, String firstname);

}
