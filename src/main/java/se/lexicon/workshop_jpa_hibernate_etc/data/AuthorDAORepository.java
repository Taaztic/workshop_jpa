package se.lexicon.workshop_jpa_hibernate_etc.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshop_jpa_hibernate_etc.models.Author;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class AuthorDAORepository implements AuthorDAO{

    private final EntityManager em;

    @Autowired
    public AuthorDAORepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(int authorId) {
        return em.find(Author.class, authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Author> findAll() {
        return em.createQuery("SELECT author FROM Author author", Author.class).getResultList();
    }

    @Override
    @Transactional
    public Author create(Author author) {
        em.persist(author);
        return author;
    }

    @Override
    @Transactional
    public Author update(Author author) {
        return em.merge(author);
    }

    @Override
    @Transactional
    public void delete(int authorId) {
        Author author = findById(authorId);
        if(author != null){
            em.remove(author);
        }
    }
}
