package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.RevisionProjet;

import java.util.Collection;

public interface IRevisionProjetService {

    Collection<RevisionProjet> getAllRevisionProjets();
    RevisionProjet getRevisionProjetById(Long RevisionProjetId);
    RevisionProjet addRevisionProjet(RevisionProjet RevisionProjet);
    void updateRevisionProjet(RevisionProjet RevisionProjet);
    void deleteRevisionProjet(Long RevisionProjetId);
}
