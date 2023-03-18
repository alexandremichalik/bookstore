package project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.bookstore.dto.BookDTO;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookDTO,String> {

    List<BookDTO> findByTitleContainingIgnoreCaseOrAuthorOrIllustrator (String title, String author, String illustrator);

}
