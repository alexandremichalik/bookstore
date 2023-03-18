package project.bookstore.model;

import java.util.Date;

public class BorrowingcardModel {

    private Long userId;
    private String bookEAN13;
    private Date realReturnDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookEAN13() {
        return bookEAN13;
    }

    public void setBookEAN13(String bookEAN13) {
        this.bookEAN13 = bookEAN13;
    }

    public Date getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(Date realReturnDate) {
        this.realReturnDate = realReturnDate;
    }
}
