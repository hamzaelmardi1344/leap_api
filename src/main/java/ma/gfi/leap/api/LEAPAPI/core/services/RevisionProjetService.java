package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.RevisionProjet;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.RevisionProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class RevisionProjetService implements IRevisionProjetService {

    @Autowired
    private RevisionProjetRepository RevisionProjetRepository;

    @Override
    public Collection<RevisionProjet> getAllRevisionProjets() {
        Collection<RevisionProjet> list = new ArrayList<>();
        RevisionProjetRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public RevisionProjet getRevisionProjetById(Long RevisionProjetId) {
        RevisionProjet RevisionProjet = RevisionProjetRepository.findById(RevisionProjetId).get();
        return RevisionProjet;
    }

    @Override
    public RevisionProjet addRevisionProjet(RevisionProjet RevisionProjet) {
        return RevisionProjetRepository.save(RevisionProjet);
    }

    @Override
    public void updateRevisionProjet(RevisionProjet RevisionProjet) {
        RevisionProjetRepository.save(RevisionProjet);
    }

    @Override
    public void deleteRevisionProjet(Long RevisionProjetId) {
        RevisionProjetRepository.delete(getRevisionProjetById(RevisionProjetId));
    }
}
