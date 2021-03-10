package se.lexicon.workshop_jpa_hibernate_etc.data;

import se.lexicon.workshop_jpa_hibernate_etc.models.Book;

import java.util.Collection;

public interface BookDAO {

    Book findById(int bookId);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int bookId);
}
