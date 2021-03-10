package se.lexicon.workshop_jpa_hibernate_etc.data;

import se.lexicon.workshop_jpa_hibernate_etc.models.BookLoan;

import java.util.Collection;

public interface BookLoanDAO {

    BookLoan findById(int bookLoanId);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int bookLoanId);

}
