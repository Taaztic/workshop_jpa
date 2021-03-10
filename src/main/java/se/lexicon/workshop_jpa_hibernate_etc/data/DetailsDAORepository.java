package se.lexicon.workshop_jpa_hibernate_etc.data;

import org.springframework.stereotype.Repository;
import se.lexicon.workshop_jpa_hibernate_etc.models.Details;

import java.util.Collection;

@Repository
public class DetailsDAORepository implements DetailsDAO{


    @Override
    public Details findByInt(int detailsId) {
        return null;
    }

    @Override
    public Collection<Details> findAll() {
        return null;
    }

    @Override
    public Details create(Details details) {
        return null;
    }

    @Override
    public Details update(Details details) {
        return null;
    }

    @Override
    public void delete(int detailsId) {

    }
}
