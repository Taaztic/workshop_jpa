package se.lexicon.workshop_jpa_hibernate_etc.models;



import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", table = "book_loan")
    private AppUser borrower;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", table = "book_loan")
    private Book book;

    public BookLoan(int loadId, LocalDate loanDate, LocalDate dueDate, boolean returned, AppUser borrower, Book book) {
        this.loanId = loadId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }

    public BookLoan(LocalDate loanDate, Book book) {
        this(0, loanDate, loanDate.plusDays(book.getMaxLoanDays()), false, null, book);

    }

    public BookLoan() {
    }

    public int getLoanId() {
        return loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
