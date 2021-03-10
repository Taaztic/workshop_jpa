package se.lexicon.workshop_jpa_hibernate_etc.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshop_jpa_hibernate_etc.models.Book;

import javax.persistence.EntityManager;
import java.util.Collection;



@Repository
public class BookDAORepository implements BookDAO{

    private final EntityManager em;

    @Autowired
    public BookDAORepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(int bookId) {
        return em.find(Book.class, bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> findAll() {
        return em.createQuery("SELECT book FROM Book book", Book.class).getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return em.merge(book);
    }

    @Override
    @Transactional
    public void delete(int bookId) {
        Book book = findById(bookId);
        if(book != null){
            em.remove(book);
        }

    }
}
