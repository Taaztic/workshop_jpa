package se.lexicon.workshop_jpa_hibernate_etc.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshop_jpa_hibernate_etc.models.AppUser;

import javax.persistence.EntityManager;

import java.util.Collection;

@Repository
public class AppUserDAORepository implements AppUserDAO{

    private final EntityManager em;

    @Autowired
    public AppUserDAORepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int appUserId) {
        return em.find(AppUser.class, appUserId);
    }

    @Override
    public Collection<AppUser> findAll() {
        return em.createQuery("SELECT user FROM AppUser user", AppUser.class).getResultList();
    }

    @Override
    public AppUser create(AppUser appUser) {
        em.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
        return em.merge(appUser);
    }

    @Override
    public void delete(int appUserId) {
        AppUser appUser = findById(appUserId);
        if(appUser != null){
            em.remove(appUser);
        }
    }
}
