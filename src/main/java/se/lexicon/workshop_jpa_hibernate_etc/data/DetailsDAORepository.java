package se.lexicon.workshop_jpa_hibernate_etc.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshop_jpa_hibernate_etc.models.AppUser;
import se.lexicon.workshop_jpa_hibernate_etc.models.Details;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class DetailsDAORepository implements DetailsDAO{

    private final EntityManager em;

    public DetailsDAORepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public Details findById(int detailsId) {
        return em.find(Details.class, detailsId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Details> findAll() {
        return em.createQuery("SELECT details FROM Details details", Details.class).getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        em.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return em.merge(details);
    }

    @Override
    @Transactional
    public void delete(int detailsId) {
        Details details = findById(detailsId);
        if (details != null) {
            em.remove(details);

        }
    }
}
