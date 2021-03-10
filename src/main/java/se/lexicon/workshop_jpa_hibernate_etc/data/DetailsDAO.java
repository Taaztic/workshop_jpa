package se.lexicon.workshop_jpa_hibernate_etc.data;

import se.lexicon.workshop_jpa_hibernate_etc.models.Details;

import javax.xml.soap.Detail;
import java.util.Collection;

public interface DetailsDAO {
    Details findByInt(int detailsId);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int detailsId);
}
