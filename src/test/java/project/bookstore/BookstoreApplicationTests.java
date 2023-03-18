package project.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.dao.DataAccessException;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;
import project.bookstore.controller.BookController;
import project.bookstore.dto.BookDTO;
import project.bookstore.service.BookService;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookstoreApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        List<BookDTO> books = new ArrayList<>();
        books.add(new BookDTO("1", 1, "serie", "tome", "title", "format", "language", "legalDepositDate", "genre", "description", 100, "author", "illustrator", 7, null));
        books.add(new BookDTO("2", 2, "serie", "tome", "title", "format", "language", "legalDepositDate", "genre", "description", 200, "author", "illustrator", 14, null));

        given(bookService.getAllBooks()). .willReturn(books);

        mockMvc.perform(get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].ean13", is("1")))
                .andExpect(jsonPath("$[0].nbCopies", is(1)))
                .andExpect(jsonPath("$[0].serie", is("serie")))
                .andExpect(jsonPath("$[0].tome", is("tome")))
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].format", is("format")))
                .andExpect(jsonPath("$[0].language", is("language")))
                .andExpect(jsonPath("$[0].legalDepositDate", is("legalDepositDate")))
                .andExpect(jsonPath("$[0].genre", is("genre")))
                .andExpect(jsonPath("$[0].description", is("description")))
                .andExpect(jsonPath("$[0].nbPages", is(100)))
                .andExpect(jsonPath("$[0].author", is("author")))
                .andExpect(jsonPath("$[0].illustrator", is("illustrator")))
                .andExpect(jsonPath("$[0].loanPeriod", is(7)))
                .andExpect(jsonPath("$[0].borrowingCardIds", is(nullValue())))
                .andExpect(jsonPath("$[1].ean13", is("2")))
                .andExpect(jsonPath("$[1].nbCopies", is(2)))
                .andExpect(jsonPath("$[1].serie", is("serie")))
                .andExpect(jsonPath("$[1].tome", is("tome")))
                .andExpect(jsonPath("$[1].title", is("title")))
                .andExpect(jsonPath("$[1].format", is("format")))
                .andExpect(jsonPath("$[1].language", is("language")))
                .andExpect(jsonPath("$[1].description", is("description")))
                .andExpect(jsonPath("$[1].nbPages", is(200)))
                .andExpect(jsonPath("$[1].author", is("author")))
                .andExpect(jsonPath("$[1].illustrator", is("illustrator")))
                .andExpect(jsonPath("$[1].loanPeriod", is(14)))
                .andExpect(jsonPath("$[1].borrowingCardIds", is(nullValue())));
    }

}