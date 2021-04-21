package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProjet;

import java.util.Collection;

public interface IAttributProjetService {

    Collection<AttributProjet> getAllAttributProjets();
    AttributProjet getAttributProjetById(Long AttributProjetId);
    AttributProjet addAttributProjet(AttributProjet AttributProjet);
    void updateAttributProjet(AttributProjet AttributProjet);
    void deleteAttributProjet(Long AttributProjetId);

}
