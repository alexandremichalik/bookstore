package project.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "borrowing_card")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BorrowingCardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDTO user;

    @ManyToOne
    @JoinColumn(name = "book_ean13")
    private BookDTO book;

    @Temporal(TemporalType.DATE)
    private Date loanDate;

    @Temporal(TemporalType.DATE)
    private Date realReturnDate;

    public BorrowingCardDTO() {

    }

    public BorrowingCardDTO(UserDTO user, BookDTO book, Date loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user.getId();
    }

    public UserDTO getUserObject() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getBook() {
        return book.getEan13();
    }

    public BookDTO getBookObject() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public String getLoanDate() {
        if(loanDate == null){
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(loanDate);
    }

    public Date getLoanDateFormat() {
        return loanDate;
    }



    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getRealReturnDate() {
        if(realReturnDate == null){
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(realReturnDate);
    }

    public void setRealReturnDate(Date realReturnDate) {
        this.realReturnDate = realReturnDate;
    }
}
