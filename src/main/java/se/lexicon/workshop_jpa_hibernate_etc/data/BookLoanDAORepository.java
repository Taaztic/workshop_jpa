package se.lexicon.workshop_jpa_hibernate_etc.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshop_jpa_hibernate_etc.models.Book;
import se.lexicon.workshop_jpa_hibernate_etc.models.BookLoan;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class BookLoanDAORepository implements BookLoanDAO{

    private final EntityManager em;

    @Autowired
    public BookLoanDAORepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(readOnly = true)
    public BookLoan findById(int bookLoanId) {
        return em.find(BookLoan.class, bookLoanId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return em.createQuery("SELECT bookloan FROM BookLoan bookloan", BookLoan.class).getResultList();
    }

    @Override
    @Transactional
    public BookLoan create(BookLoan bookLoan) {
        em.persist(bookLoan);
        return bookLoan;
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return em.merge(bookLoan);
    }

    @Override
    @Transactional
    public void delete(int bookLoanId) {
        BookLoan bookLoan = findById(bookLoanId);
        if(bookLoan != null){
            em.remove(bookLoan);
        }

    }
}
