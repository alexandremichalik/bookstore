package project.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String lastname;
    private String firstname;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressDTO address;

    @OneToMany(mappedBy = "user")
    private List<BorrowingCardDTO> borrowingCardIds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
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
