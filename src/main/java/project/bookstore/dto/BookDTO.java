package project.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookDTO {

    @Id
    private String ean13;

    private int nbCopies;
    private String serie;
    private String tome;
    private String title;
    private String format;
    private String language;
    private String legalDepositDate;
    private String genre;
    private String description;
    private int nbPages;
    private String author;
    private String illustrator;
    private int loanPeriod;

    @OneToMany(mappedBy = "book")
    private List<BorrowingCardDTO> borrowingCardIds;

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public int getNbCopies() {
        return nbCopies;
    }

    public void setNbCopies(int nbCopies) {
        this.nbCopies = nbCopies;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTome() {
        return tome;
    }

    public void setTome(String tome) {
        this.tome = tome;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLegalDepositDate() {
        return legalDepositDate;
    }

    public void setLegalDepositDate(String legalDepositDate) {
        this.legalDepositDate = legalDepositDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public List<Integer> getBorrowingCardIds() {
        List<Integer> ids = new ArrayList<>();
        for (BorrowingCardDTO borrowingCard : borrowingCardIds) {
            ids.add(borrowingCard.getId().intValue());
        }
        return ids;
    }

    public void setBorrowingCardIds(List<Integer> ids) {
        List<BorrowingCardDTO> borrowingCards = new ArrayList<>();
        for (Integer id : ids) {
            BorrowingCardDTO borrowingCard = new BorrowingCardDTO();
            borrowingCard.setId(id.longValue());
            borrowingCards.add(borrowingCard);
        }
        this.borrowingCardIds = borrowingCards;
    }
}
