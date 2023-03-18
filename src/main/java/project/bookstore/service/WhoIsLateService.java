package project.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.bookstore.dto.BookDTO;
import project.bookstore.dto.BorrowingCardDTO;
import project.bookstore.dto.UserDTO;
import project.bookstore.model.WhoIsLate;
import project.bookstore.repository.BorrowingCardRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WhoIsLateService {


    @Autowired
    private BorrowingCardRepository borrowingCardRepository;

    public List<WhoIsLate> findWhoIsLateDTO() {
        List<WhoIsLate> resultList = new ArrayList<>();

        List<BorrowingCardDTO> borrowingCards = borrowingCardRepository.findByRealReturnDateIsNull();

        for (BorrowingCardDTO borrowingCard : borrowingCards) {
            BookDTO book = borrowingCard.getBookObject();
            UserDTO user = borrowingCard.getUserObject();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(borrowingCard.getLoanDateFormat());
            calendar.add(Calendar.DATE, book.getLoanPeriod());
            Date dueDate = calendar.getTime();

            if (dueDate.before(new Date())) {
                WhoIsLate whoIsLate = new WhoIsLate();
                whoIsLate.setEmail(user.getEmail());
                whoIsLate.setLastname(user.getLastname());
                whoIsLate.setFirstname(user.getFirstname());
                whoIsLate.setEan13(book.getEan13());
                whoIsLate.setTitle(book.getTitle());
                whoIsLate.setLoanPeriod(addDaysToDate(borrowingCard.getLoanDateFormat(), book.getLoanPeriod()));
                whoIsLate.setLoanDate(borrowingCard.getLoanDateFormat());
                resultList.add(whoIsLate);
            }
        }
        return resultList;
    }

    private Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

}
