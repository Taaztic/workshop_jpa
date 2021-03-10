package se.lexicon.workshop_jpa_hibernate_etc.data;

import se.lexicon.workshop_jpa_hibernate_etc.models.Author;

import java.util.Collection;

public interface AuthorDAO {

    Author findById(int authorId);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int authorId);
}
