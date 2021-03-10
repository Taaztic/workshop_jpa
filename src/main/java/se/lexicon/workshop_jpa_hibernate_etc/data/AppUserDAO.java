package se.lexicon.workshop_jpa_hibernate_etc.data;

import se.lexicon.workshop_jpa_hibernate_etc.models.AppUser;

import java.util.Collection;

public interface AppUserDAO {
    AppUser findById(int appUserId);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int appUserId);

}
